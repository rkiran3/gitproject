import re
import os
import string
from os.path import join

mypath = 'd:\\data'

for root, dirs, files in os.walk(mypath):
    for entry in files:
        completep = os.path.join(root, entry)
        if (re.compile('d:\\\\data\\\\General').match(completep)):
            s = string.replace(completep, 'd:\\', '%BPCSHOME%\\')
            print
            s

if re.compile('d:\\\\data').match(mypath):
    print ("Matches")