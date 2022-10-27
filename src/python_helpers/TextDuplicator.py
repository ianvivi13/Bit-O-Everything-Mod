
seperator = "\n"
search = 'orange'

woodTypes = (
    "peach",
    "plum",
    "pear",
)

with open('duplicate.txt','r') as file:
    data = file.read()

with open('duplicate.txt','a') as file:
    for single in woodTypes:
        newdata = data.replace(search, single)
        newdata = newdata.replace(search.upper(), single.upper())
        newdata = newdata.replace(search.capitalize(), single.capitalize())
        file.write(seperator + newdata)


# all lower
# all upper
# front upper