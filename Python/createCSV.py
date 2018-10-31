import re
import csv

# open a file that contain Anki Question-Answer chunks
# each chunk is separated by a delimiter, in this case ---- 
# each Ques-Ans look like
# Q: What is first month of year
# A: January
# ----
outputFile = "C:\\tmp\\demo-anki.txt"
f = open(outputFile, 'r')

# use this pattern to separate each QA chunk
pattern = r'(.*?)----'
p = re.compile(pattern, re.DOTALL|re.MULTILINE)

# use this pattern to identify Ques-Ans
qPattern = r'Q:(.*?)A:(.*)'

chunks = re.findall(pattern, f.read(), re.DOTALL|re.MULTILINE)

# accumulate each Ques-Ans in a dictionary
dictQA = {}
    
for chunk in chunks:
    match = re.search(qPattern, chunk.strip(), flags = re.DOTALL|re.MULTILINE)
    if match:
        #print ("Question: [", match.group(1), "]")
        #print ("Answer:   [", match.group(2), "]")
        dictQA [match.group(1)] = match.group(2)

print ("Writing ", len(dictQA), " Ques-Ans chunks to file " + outputFile )        
# write the dictionary as comma separated fields into CSV
with open("c:\\tmp\\demo-anki.csv", "w") as out:
    csv_out = csv.writer(out)
    for key, value in dictQA.items():
        csv_out.writerow([key.strip(), value.strip()])

print ("End")
