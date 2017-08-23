from bs4 import BeautifulSoup
import urllib3
import re

# specify data
data = ''''<div>
                <a href="testing.html">Testing</a>
            </div>'''
soup = BeautifulSoup(data, "lxml")
name_box = soup.find('a')
for link in soup.findAll('a'):
    print (link['href'])


data2 = ''''<div>d
                <a href="Testing.html" class=" 202193">Check this
                    <span>
                        <h5>This is heading</h5>
                    </span>
                </a>
            </div>'''
soup2 = BeautifulSoup(data2, "lxml")

#for link in soup.findAll('a', attrs={'class':'1234'}):  # use a regular expression for this
for link in soup2.findAll('a', attrs={'class': re.compile(' \d+')}):
    print (link['href'])
    #print(link.string)
    for child in link.findAll('span'):
        imgNodes = child.findAll('h5')
        for imgNode in imgNodes:
            print (imgNode.string + "\n")

