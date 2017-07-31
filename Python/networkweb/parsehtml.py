from bs4 import BeautifulSoup
import urllib3
import re

# specify url
target_page = 'http://website/management/'

# query the website and return the html
http = urllib3.PoolManager()
response = http.request('GET', target_page)

soup = BeautifulSoup(response.data, "lxml")
name_box = soup.find('h1', attrs={'class':'name'})

#for link in soup.findAll('a', attrs={'class':' 2020893'}):
for link in soup.findAll('a', attrs={'class': re.compile(' \d+')}):
    print (link['href'])
    #print(link.string)
    for child in link.findAll('article'):
        imgNodes = child.findAll('h5')
        for imgNode in imgNodes:
            print (imgNode.string + "\n")
