#!c:/apps/python32/python.exe

################## map #############################
# return a modified value
def getModifiedPrice(price):
    """
    >>> list(map(getModifiedPrice, range(1,5)))
    [1.1, 2.2, 3.3, 4.4]
    """
    modifier = 1.1
    # convert to floating point number with 2 digits after decimal point
    return round(price*modifier, 2)

################## map #############################
fd = open("/tmp/price.txt")   # contains tab delimited rows
# return a value that exists at a particular column in input string
def getPrice(line):
    price = line.split("\t")[3] # price exists at index 3
    price = price.strip()   # remove spaces, newlines
    return int(price)       # convert to integer

# get a list of int values
# invoke getPrice() on each element in list
priceList = list(map(getPrice, fd.readlines()))
print (priceList) # prints a list of values found in the input file

if __name__ == "__main__":
    import doctest
    doctest.testmod()
