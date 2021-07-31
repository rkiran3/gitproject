# list comprehensions allow us to filter elements or process on each element
# in the list thus creating a separate list

# For example, we can create a separate list that contains only elements
# whose values ends with .com

[entry for entry in ["a@yahoo.com", "c@gmail.net"] if entry.endswith("com")]

['a@yahoo.com']
