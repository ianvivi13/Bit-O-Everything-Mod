from ast import While
import re
from TexSoup import TexSoup
from TexSoup.utils import to_list
from enum import Enum
from GroupingLocater import GroupingLocater as GroupLoc

class Node(object):
    DEFAULT_SEPERATOR = "|  "
    TAB_SEPERATOR = "    "
    seperator = DEFAULT_SEPERATOR
    useBrackets = True

    def __init__(self):
        return

    def print(self):
        print(self)
        return self

class ArgumentNode(Node):
    def __init__(self, value):
        self.value = value
    
    def __str__(self, lvl = 0):
        indent = super().seperator * lvl
        return indent + self.value.__str__()

class FunctionNode(Node):
    def __init__(self, function):
        self.function = function
        self.branches = []
    
    def append(self, branch):
        self.branches.append(branch)
        return self

    def __str__(self, lvl = 0):
        indent = super().seperator * lvl
        ret = indent + self.function.__str__()
        if super().useBrackets:
            ret += " ["
        else:
            ret += ":"
        for branch in self.branches:
            ret += "\n" + branch.__str__(lvl + 1)
        if super().useBrackets:
            return ret + "\n" + indent + "]"
        else:
            return ret

class LatexVariableSimplifier(object):
    class firstCharacter(Enum):
        NONE = "NONE"           # first character will be removed
        UPPERCASE = "UPPERCASE" # first character will be uppercase
        LOWERCASE = "LOWERCASE" # first character will be lowercase
        AS_IS = "AS_IS"         # first character will remain as it was typed
    
    class laterCharacters(Enum):
        NONE = "NONE"           # later characters will be removed
        UPPERCASE = "UPPERCASE" # later characters will all be uppercase
        LOWERCASE = "LOWERCASE" # later characters will all be lowercase
        AS_IS = "AS_IS"         # later characters will remain as they were typed
        CAMEL = "CAMEL"         # the first character will be uppercase, the rest will be lowercase

    def __init__(self, firstFormat = firstCharacter.UPPERCASE, laterFormat = laterCharacters.LOWERCASE):
        '''
        Latex variables are in the form #_{????}
            # is one A-Za-z character
            ? is multiple A-Za-z1-9 characters
        they will be transformed into the form #???? according to the methods selected
        '''
        self.first = firstFormat
        self.later = laterFormat

    def transformVariable(self, firstString, laterString):
        if (self.first == LatexVariableSimplifier.firstCharacter.UPPERCASE):
            firstString = firstString.upper()
        elif (self.first == LatexVariableSimplifier.firstCharacter.LOWERCASE):
            firstString = firstString.lower()
        elif (self.first == LatexVariableSimplifier.firstCharacter.NONE):
            firstString = ""

        if (self.later == LatexVariableSimplifier.laterCharacters.UPPERCASE):
            laterString = laterString.upper()
        elif (self.later == LatexVariableSimplifier.laterCharacters.LOWERCASE):
            laterString = laterString.lower()
        elif (self.later == LatexVariableSimplifier.laterCharacters.CAMEL):
            laterString = laterString.capitalize()
        elif (self.later == LatexVariableSimplifier.laterCharacters.NONE):
            laterString = ""
        
        return firstString + laterString

    def __str__(self):
        new = "\n"
        ret = "First Format: " + self.first.__str__() + new + "Second Format: " + self.later.__str__()
        arrow = " -> "
        possible = [
            ("A","alpha"),
            ("k","EXAMple"),
            ("R","Ratio"),
            ("f","test"),
            ("Q","FACTOR"),
        ]
        for f, s in possible:
            oldForm = f + "_{" + s + "}"
            newForm = self.transformVariable(f, s)
            demo = new + oldForm + arrow + newForm
            ret += demo
        return ret

class FunctionTreeBuilder(object):
    def __init__(self):
        self.latex = ""
        self.variableSimplifier = LatexVariableSimplifier()

    def appendLatex(self, *kwargs):
        for item in kwargs:
            self.latex += item
        return self

    def print(self):
        print(self)
        return self

    def fixOperatorNames(self):
        latex = self.latex
        def stringReplacePosition(string, pos, char):
            return string[:pos] + char + string[pos+1:]
        pattern = re.compile("\\\\operatorname\\{[a-zA-Z]+\\}", re.IGNORECASE)
        while True:
            search = pattern.search(latex)
            if search is None:
                break
            group = search.group()
            start, end = search.span()
            first = None
            matching = None
            depth = 0
            for c in range(end, len(latex)):
                if first is None:
                    if latex[c] == '(':
                        first = c
                else:
                    if latex[c] == ')':
                        if depth == 0:
                            matching = c
                            break
                        else:
                            depth -= 1
                    elif latex[c] == '(':
                        depth += 1
            latex = stringReplacePosition(latex, matching, r'}')
            latex = stringReplacePosition(latex, first, r'{')
            funName = group.replace("\\operatorname{", "")[:-1]
            latex = latex[:start] + "\\" + funName + latex[end:]
        self.latex = latex
        return self

    def setVariableSimplifier(self, latexVariableSimplifier):
        self.variableSimplifier = latexVariableSimplifier

    def simplifyVariables(self, latexVariableSimplifier = None, shouldPrint = True):
        if latexVariableSimplifier is None:
            latexVariableSimplifier = self.variableSimplifier
        pattern = re.compile("[a-zA-Z]_\{[a-zA-Z]+\}", re.IGNORECASE)
        while True:
            search = pattern.search(self.latex)
            if search is None:
                break
            old = search.group()
            new = latexVariableSimplifier.transformVariable(old[0],old[3:len(old)-1])
            self.latex = self.latex.replace(old, new)
            if shouldPrint:
                print(old, " -> " , new)
        return self

    def __str__(self):
        return self.latex

    def replaceUseless(self):
        list = [
            r"\left",
            r"\right"
        ]
        for item in list:
            self.latex = self.latex.replace(item, "")
        return self

    def fixPower(self):
        latex = self.latex
        def findNonAlpha(latex, start, forward = True):
            # returns first value that isn't part of (A-Za-z0-9!)
            valid = ("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9","!")
            if forward:
                r = range(start, len(latex), 1)
            else:
                r = range(start, -1, -1)
            for i in r:
                if latex[i].lower() not in valid:
                    return i
    
        while True:
            next = GroupLoc.findNextCharacter(latex, 0, "^")
            if (next == None):
                break
            pos = next[0]

            forward = GroupLoc.getNextGrouping(latex, pos, GroupLoc.Grouping.PARENTHESES, GroupLoc.Grouping.BRACES)
            backward = GroupLoc.getPreviousGrouping(latex, pos, GroupLoc.Grouping.PARENTHESES, GroupLoc.Grouping.BRACES)

            if (backward is None) or (backward.end + 1 != pos):
                t = findNonAlpha(latex, pos-1, forward=False)
                backward = GroupLoc.Group(latex, t, pos, GroupLoc.Grouping.NONE)
                backward.start += 1

            new = "\power{" + backward.contents + "}{" + forward.contents + "}"
            old = latex[backward.start : forward.end + 1]
            latex = latex.replace(old,new)

        self.latex = latex
        return self

    def turnToTree(soup, lvl = 0, shouldPrint = True):
        dist = " | " * lvl
        try:
            cont = soup.contents
            if shouldPrint:
                print(dist, soup.name, "[")
            funct = FunctionNode(soup.name)
            for item in cont:
                node = FunctionTreeBuilder.turnToTree(item, lvl + 1, shouldPrint = shouldPrint)
                funct.append(node)
            if shouldPrint:
                print(dist, "]")
            return funct
        except:
            if shouldPrint:
                print(dist, soup)
            return ArgumentNode(soup)
    
    def fixAll(self):
        self.replaceUseless()
        self.simplifyVariables(shouldPrint=False)
        self.fixOperatorNames()
        self.fixPower()
        return self

    def build(self, shouldPrint = True):
        soup = TexSoup(self.latex)
        return FunctionTreeBuilder.turnToTree(soup, shouldPrint = shouldPrint)


best = r"\frac{P}{\left|P\right|}\left(\frac{v-m}{M-m}\right)^{\left|P\right|}+\left|\frac{\frac{P}{\left|P\right|}-1}{2}\right|"
other = r"\operatorname{floor}\left(\frac{V_{value}}{L_{lock}}+\frac{1}{2}\right)"
testing = r"\frac{\frac{Insidefirst}{Insidesecond}}{second}+\frac{another}{last}"
power = r"\frac{{W_{work}^{3}}}{7^{\frac{2}{l_{hi}}}}"

pow2 = r"\left(\frac{5+2^{3}}{h_{i}^{l}}\right)^{32}"
pTest = r"5^(7)"
''' SPECIAL FIXES
power - FIXED
multiplication
addition
subtraction
factorial
'''

tree = FunctionTreeBuilder().appendLatex(pTest).print().fixAll().print().build(shouldPrint = False)
Node.seperator = Node.TAB_SEPERATOR
Node.useBrackets = False
tree.print()





