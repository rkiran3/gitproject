import re
import os
import string
import glob
from os.path import join


mypath = 'd:\\data'

# for root, dirs, files in os.walk(mypath):
#     for entry in files:
#         completep = os.path.join(root, entry)
#         if (re.compile('d:\\\\data\\\\General').match(completep)):
#             s = string.replace(completep, 'd:\\', '%HOME%\\')
#
# if re.compile('d:\\\\data').match(mypath):
#     print ("Matches")

moviefolder = "C:" + os.sep + "tmp" + os.sep + "Anubhava"
webfilename = "Hodeya.Doora.mp3"
diskfilenames = os.listdir(moviefolder)

for diskfile in diskfilenames:
    if re.search(webfilename, diskfile, re.IGNORECASE):
        print("found " + diskfile)