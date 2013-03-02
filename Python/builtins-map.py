#!c:/apps/python32/python.exe

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
