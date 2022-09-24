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

    def assertFilesExist(fileName):
        if isinstance(fileName, tuple):
                for f in fileName:
                    if not os.path.isfile(f):
                        print("File not found: " + f)
        else:
            if not os.path.isfile(fileName):
                        print("File not found: " + f)

    def Undo():
        dup._Undo(dup.LoadFromPickle("meta/prev.pckl"))

Dir = "../main/resources/assets/bit_o_everything/"
Blockstates = Dir + "blockstates/"
BlockModels = Dir + "models/block/"
ItemModels = Dir + "models/item/"

woodTypes = (
    "maple",
    "dogwood",
    "redwood",
    "olive",
    "peach",
    "ebony",
    "plum",
    "orange",
    "infected",
    "corrupt",
    "pear",
    "wisteria",
    "charred",
    "ice",
    "dead"
)

files = (
    Blockstates + "cherry_button.json",
    Blockstates + "cherry_door.json",
    Blockstates + "cherry_fence.json",
    Blockstates + "cherry_fence_gate.json",
    Blockstates + "cherry_leaves.json",
    Blockstates + "cherry_log.json",
    Blockstates + "cherry_planks.json",
    Blockstates + "cherry_pressure_plate.json",
    Blockstates + "cherry_sapling.json",
    Blockstates + "cherry_sign.json",
    Blockstates + "cherry_slab.json",
    Blockstates + "cherry_stairs.json",
    Blockstates + "cherry_trapdoor.json",
    Blockstates + "cherry_wall_sign.json",
    Blockstates + "cherry_wood.json",
    Blockstates + "potted_cherry_sapling.json",
    Blockstates + "stripped_cherry_log.json",
    Blockstates + "stripped_cherry_wood.json",
    BlockModels + "cherry_button.json",
    BlockModels + "cherry_button_inventory.json",
    BlockModels + "cherry_button_pressed.json",
    BlockModels + "cherry_door_bottom_left.json",
    BlockModels + "cherry_door_bottom_left_open.json",
    BlockModels + "cherry_door_bottom_right.json",
    BlockModels + "cherry_door_bottom_right_open.json",
    BlockModels + "cherry_door_top_left.json",
    BlockModels + "cherry_door_top_left_open.json",
    BlockModels + "cherry_door_top_right.json",
    BlockModels + "cherry_door_top_right_open.json",
    BlockModels + "cherry_fence_gate.json",
    BlockModels + "cherry_fence_gate_open.json",
    BlockModels + "cherry_fence_gate_wall.json",
    BlockModels + "cherry_fence_gate_wall_open.json",
    BlockModels + "cherry_fence_inventory.json",
    BlockModels + "cherry_fence_post.json",
    BlockModels + "cherry_fence_side.json",
    BlockModels + "cherry_leaves.json",
    BlockModels + "cherry_log.json",
    BlockModels + "cherry_log_horizontal.json",
    BlockModels + "cherry_planks.json",
    BlockModels + "cherry_pressure_plate.json",
    BlockModels + "cherry_pressure_plate_down.json",
    BlockModels + "cherry_sapling.json",
    BlockModels + "cherry_sign.json",
    BlockModels + "cherry_slab.json",
    BlockModels + "cherry_slab_top.json",
    BlockModels + "cherry_stairs.json",
    BlockModels + "cherry_stairs_inner.json",
    BlockModels + "cherry_stairs_outer.json",
    BlockModels + "cherry_trapdoor_bottom.json",
    BlockModels + "cherry_trapdoor_open.json",
    BlockModels + "cherry_trapdoor_top.json",
    BlockModels + "cherry_wood.json",
    BlockModels + "potted_cherry_sapling.json",
    BlockModels + "stripped_cherry_log.json",
    BlockModels + "stripped_cherry_log_horizontal.json",
    BlockModels + "stripped_cherry_wood.json",
    ItemModels + "cherry_boat.json",
    ItemModels + "cherry_button.json",
    ItemModels + "cherry_chest_boat.json",
    ItemModels + "cherry_door.json",
    ItemModels + "cherry_fence.json",
    ItemModels + "cherry_fence_gate.json",
    ItemModels + "cherry_leaves.json",
    ItemModels + "cherry_log.json",
    ItemModels + "cherry_planks.json",
    ItemModels + "cherry_pressure_plate.json",
    ItemModels + "cherry_sapling.json",
    ItemModels + "cherry_sign.json",
    ItemModels + "cherry_slab.json",
    ItemModels + "cherry_stairs.json",
    ItemModels + "cherry_trapdoor.json",
    ItemModels + "cherry_wood.json",
    ItemModels + "stripped_cherry_log.json",
    ItemModels + "stripped_cherry_wood.json"
)

replace = "cherry"

#dup.assertFilesExist(files)
dup.DuplicateFile(files, replace, woodTypes)
#dup.Undo()