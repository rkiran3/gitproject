import re

with open("/tmp/extractjavasnippet.txt") as inputFile:
    read_data = inputFile.read()

    pattern = r'<pre class="brush: sql">(.*?)</pre>'
    p = re.compile(pattern, re.DOTALL | re.MULTILINE)

    chunks = re.findall(pattern, read_data, re.DOTALL | re.MULTILINE)

    for chunk in chunks:
        print("------")
        print(chunk)
