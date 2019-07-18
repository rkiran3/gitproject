import re
import csv

csv_outfile =  open('C:\\Users\\rkiran\\Downloads\\PublisherDataSet.sql', 'w', newline='')
csv_writer = csv.writer(csv_outfile, delimiter=',')

# open a CSV file that contain fields chunks

with open('C:\\Users\\rkiran\\Downloads\\PublisherDataSet.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    count=0;
    
    for row in csv_reader:
        #print (row)
        columns = []
        colcount = 0
        for column in row:
            column = column.replace('\n', "")
            if colcount==2:
                #print (column.split(",")[0])
                column = column.split(",")[0]
            columns.append(column)
            colcount= colcount+1
        print(columns[0] + "|" + columns[1] + "|" + columns[2] + "|" + columns[3] + "|" + columns[4] + "|" + columns[5])
        mystr = r"insert into catalog_publisher (name, address, city, state_province, country, website) values ('{}', '{}', '{}', '{}', '{}', '{}');"
        formattedstr = mystr.format(columns[0], columns[1], columns[2], columns[3], 'USA', columns[5])
        #print ('insert into catalog (name, address, city, state_province, country, website) values ('"'" + columns[0] + '"'"')')
        print ([formattedstr])
        count = count+1
        #if (count > 3):
        #    break
        csv_writer.writerow([formattedstr])
        
csv_outfile.close()

            

