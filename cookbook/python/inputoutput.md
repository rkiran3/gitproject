# Table of Contents
1. [Open a file for reading](#openfileread01)

# Open a file for reading  <a name="openfileread01"></a>
Frequently we need to be able to open a file that contains specific data for reading and processing contents. For example: we may have a file that contains records separated on each line, or a huge data file.
<br>
We can read in the file contents using `open` as shown.  `open` returns a file object and normally they are opened in read mode.
<br >
In this case we use `with` so that the file object is closed after program terminates.
<pre>
import re

with open("C:\\tmp\\snippet.txt") as inputFile:
    read_data = inputFile.read()

    pattern = r'&lt;pre class="brush: sql"&gt;(.*?)&lt;/pre&gt;'
    p = re.compile(pattern, re.DOTALL|re.MULTILINE)

    chunks = re.findall(pattern, read_data, re.DOTALL|re.MULTILINE)

    for chunk in chunks:
        print("------")
        print (chunk)
        
</pre>
