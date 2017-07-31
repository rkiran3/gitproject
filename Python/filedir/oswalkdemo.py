# start looking at directory 'c:\\' and look for files 
# that match .dsp

import glob
import os

for root, dirs, files in os.walk('c:\\tmp'):
    # go to that directory
    os.chdir(root)

    # get only files that match .dsp 	glob.glob is function that takes an argument to match
    mylist = glob.glob('*.xml')

    # print only interested directories
    if (mylist):
        for entry in mylist:
            print(os.path.join(root, entry))