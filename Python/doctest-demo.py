"""
>>> aList=["this", "is", "great"]
>>> aList[0]
'this'
"""
def fun():
	"""
	>>> fun()
	'abc'
	"""
	return 'abc'

if __name__ == '__main__':
	import doctest
	doctest.testmod()
