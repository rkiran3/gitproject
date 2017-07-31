import os, glob, sys

path = 'C:\\tmp'
for root, dirs, files in os.walk(path):
    os.chdir(root)

    # find all files that match log*
    logs = glob.glob('*log*')
    if logs:
        for fname in logs:
            fullpath = os.path.join(root, fname)
            print(fullpath)
            # Identify files of len 3 lines long and delete them
            count = len(open(fullpath).readlines())
            if count == 3 or count == 2:
                print('Removing ', fullpath)
		        #os.remove(fullpath)