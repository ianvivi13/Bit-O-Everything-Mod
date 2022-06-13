import os
from pickle import load, dump

class dup:
    def SaveToPickle(item,path):
        f = open(path, 'wb')
        dump(item,f)
        f.close()
        return

    def LoadFromPickle(path):
        f = open(path, 'rb')
        l = load(f)
        f.close()
        return l

    def _Undo(files):
        if isinstance(files, str):
            if os.path.exists(files):
                os.remove(files)
        else:
            for f in files:
                dup._Undo(f)

    def _DupWithError(fileName, search: str, replace: tuple) -> list:
        total = []
        try:
            if isinstance(fileName, tuple):
                for f in fileName:
                    total.append(dup._DupWithError(f, search, replace))
                return total
            if not isinstance(fileName, str):
                raise TypeError("fileNames inside tuple must be a string")
            if not isinstance(search, str):
                raise TypeError("search must be a string")
            if not isinstance(replace, tuple):
                raise TypeError("replace must be a tuple of strings")
            with open(fileName ,'r') as file:
                data = file.read()
            for single in replace:
                total.append(fileName.replace(search,single))
                with open(fileName.replace(search,single), 'x') as file:
                    file.write(data.replace(search,single))
            return total
        except Exception as e:
            print(e)
            dup._Undo(total)
            raise FileNotFoundError("undid changes")

    def DuplicateFile(fileName, search: str, replace: tuple):
        '''
        Duplicates file <filename> by replacing all occurances of <search> with <replace>. Will duplicate for each item in replace.
        \n
            fileName - string name or tuple containing all files to preform action on
            search - string to search for
            replace - tuple of strings to replace with
        '''
        print("attempting to duplicate files")
        try:
            l = dup._DupWithError(fileName, search, replace)
            print("duplication succeeded:")
            print(l)
            dup.SaveToPickle(l,"meta/prev.pckl")
        except Exception as e:
            print(e)
            print("duplication failed: automagically undoing file creation")

    def Undo():
        dup._Undo(dup.LoadFromPickle("meta/prev.pckl"))


colors = (
    "orange",
    "magenta",
    "light_blue",
    "yellow",
    "lime",
    "pink",
    "gray",
    "light_gray",
    "cyan",
    "purple",
    "blue",
    "brown",
    "green",
    "red",
    "black"
)


Dir = "../main/resources/assets/bit_o_everything/"
Blockstates = Dir + "blockstates/"
BlockModels = Dir + "models/block/"
ItemModels = Dir + "models/item/"

files = (
    "duplicate/white.txt",
    "duplicate/lol/other_white.txt"
)


test = (
    "newphalt",
    "oldphalt"
)

f = (
    ItemModels + "asphalt.json",
    BlockModels + "asphalt.json"
)

dup.DuplicateFile(f, "asphalt", test)

#dup.DuplicateFile(files, "white", colors)
#dup.Undo()