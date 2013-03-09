#!/usr/local/python.exe
"""
>>> names = ['bob', 'sue schalk' ]
>>> list(map(lambda x : x.title(), names))
['Bob', 'Sue Schalk']
>>>

>>> list(filter(lambda x : x%2==0, range(10)))
[0, 2, 4, 6, 8]
>>>

"""

if __name__ == "__main__":
    import doctest
    doctest.testmod()
