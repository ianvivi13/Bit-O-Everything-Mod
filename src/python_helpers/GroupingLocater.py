from enum import Enum

class GroupingLocater(object):
    class Group(object):
        def __init__(self, string, start, end, grouping):
            self.string = string
            self.start = start
            self.end = end
            self.contents = string[start + 1:end]
            self.grouping = grouping

        def __str__(self):
            return self.start.__str__() + " : \"" + self.grouping.value[0].__str__() + self.contents.__str__() + self.grouping.value[1].__str__() +"\" : " + self.end.__str__() + " in \"" + self.string.__str__() + "\""

    class Grouping(Enum):
        BRACKETS = ("[","]")
        BRACES = ("{","}")
        PARENTHESES = ("(",")")
        COMPARATORS = ("<",">")
        NONE = ("","")

    @classmethod
    def findNextCharacter(cls, string, start, *chars):
        assert(type(string) is str)
        assert(type(start) is int)
        assert((start <= len(string) - 1) and start >= 0)
        for char in chars:
            assert(type(char) is str and len(char) == 1)
        for i in range(start, len(string)):
            for char in chars:
                if string[i] == char:
                    return i, char
        return None

    @classmethod
    def findPreviousCharacter(cls, string, start, *chars):
        assert(type(string) is str)
        assert(type(start) is int)
        assert((start <= len(string) - 1) and start >= 0)
        for char in chars:
            assert(type(char) is str and len(char) == 1)
        for i in reversed(range(0, start + 1)):
            for char in chars:
                if string[i] == char:
                    return i, char
        return None

    @classmethod
    def findClosingMatch(cls, string, group, start):
        assert(type(string) is str)
        assert(group in cls.Grouping)
        assert(type(start) is int)
        assert(start <= (len(string) - 1) and start >= 0)
        opening, closing = group.value
        assert(string[start] == opening)
        depth = 0
        for i in range(start + 1, len(string)):
            char = string[i]
            if char == opening:
                depth += 1
                continue
            if char == closing:
                if depth == 0:
                    return cls.Group(string, start, i, group)
                else:
                    depth -= 1
                    continue
        return None

    @classmethod
    def findOpeningMatch(cls, string, group, start):
        assert(type(string) is str)
        assert(group in cls.Grouping)
        assert(type(start) is int)
        assert(start <= (len(string) - 1) and start >= 0)
        opening, closing = group.value
        assert(string[start] == closing)
        depth = 0
        for i in reversed(range(0, start)):
            char = string[i]
            if char == closing:
                depth += 1
                continue
            if char == opening:
                if depth == 0:
                    return cls.Group(string, i, start, group)
                else:
                    depth -= 1
                    continue
        return None

    @classmethod
    def getNextGrouping(cls, string, start, *groups):
        assert(type(string) is str)
        assert((start <= len(string) - 1) and start >= 0)
        l = []
        for group in groups:
            assert(group in cls.Grouping)
            l.append(group.value[0])
        found = cls.findNextCharacter(string, start, *l)
        if found is not None:
            start, char = found
            grouping = cls.findGroup(char)
            match = cls.findClosingMatch(string, grouping, start)
            if match is not None:
                end = match.end
                return cls.Group(string, start, end, grouping)
        return None
    
    @classmethod
    def getPreviousGrouping(cls, string, start, *groups):
        assert(type(string) is str)
        assert((start <= len(string) - 1) and start >= 0)
        l = []
        for group in groups:
            assert(group in cls.Grouping)
            l.append(group.value[1])
        found = cls.findPreviousCharacter(string, start, *l)
        if found is not None:
            end, char = found
            grouping = cls.findGroup(char)
            match = cls.findOpeningMatch(string, grouping, end)
            if match is not None:
                start = match.start
                return cls.Group(string, start, end, grouping)
        return None

    @classmethod
    def findGroup(cls, char):
        for group in cls.Grouping:
            if (char in group.value):
                return group
        return None