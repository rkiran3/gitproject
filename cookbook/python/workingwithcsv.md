# Table of Contents
1. [Create a List of Integers from Array of primitive integers](#example)

# Write to row file in Windows <a name="example"></a>

When we write a csv row to file, we may find it shows up with lines in between,
to avoid that - use flag newline= ''


csvfile = open("C:\\tmp\\filename.csv", 'w', newline='')
writer = csv.writer(csvfile, dialect='excel')

    csvrow = [val1, val2, val3]
    writer.writerow(csvrow)