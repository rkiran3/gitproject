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
