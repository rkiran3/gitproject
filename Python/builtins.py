#!/usr/local/python

################## sorted #############################
"""
>>> names = ['Chris', 'Brown', 'Jack']
>>> sorted_names = sorted(names)
>>> print (sorted_names)
['Brown', 'Chris', 'Jack']
""" 
names = ['Chris', 'Brown', 'Jack']

sorted_names = sorted(names)

if __name__ == "__main__":
    import doctest
    doctest.testmod()

################## sorted #############################
>>> import random
>>> [ random.randint(1,x) for x in range(1,15)]
[1, 2, 3, 3, 2, 5, 4, 4, 6, 9, 10, 2, 10, 12]
>>> sorted([ random.randint(1,x) for x in range(1,15)])
[1, 1, 2, 2, 2, 3, 3, 3, 6, 6, 6, 7, 9, 10]
>>>