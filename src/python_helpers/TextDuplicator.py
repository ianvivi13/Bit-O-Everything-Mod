
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

colors2 = (
    "white_terracotta",
    "orange_terracotta",
    "magenta_terracotta",
    "light_blue_terracotta",
    "yellow_terracotta",
    "lime_terracotta",
    "pink_terracotta",
    "gray_terracotta",
    "light_gray_terracotta",
    "cyan_terracotta",
    "purple_terracotta",
    "blue_terracotta",
    "brown_terracotta",
    "green_terracotta",
    "red_terracotta",
    "black_terracotta",
    "white_concrete",
    "orange_concrete",
    "magenta_concrete",
    "light_blue_concrete",
    "yellow_concrete",
    "lime_concrete",
    "pink_concrete",
    "gray_concrete",
    "light_gray_concrete",
    "cyan_concrete",
    "purple_concrete",
    "blue_concrete",
    "brown_concrete",
    "green_concrete",
    "red_concrete",
    "black_concrete"
)

seperator = "\n"
search = 'zinc_nugget'

nuggets = (
    "titanium_nugget",
    "tin_nugget",
    "silver_nugget",
    "sapphire_shard",
    "ruby_shard",
    "pyrite_nugget",
    "magnesium_nugget",
    "lead_nugget",
    "emerald_shard",
    "diamond_shard",
    "copper_nugget"
)

with open('duplicate.txt','r') as file:
    data = file.read()

with open('duplicate.txt','a') as file:
    for single in nuggets:
        newdata = data.replace(search, single)
        newdata = newdata.replace(search.upper(), single.upper())
        newdata = newdata.replace(search.capitalize(), single.capitalize())
        file.write(seperator + newdata)


# all lower
# all upper
# front upper