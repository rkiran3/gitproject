#!/bin/python

import feedparser
import sys

urlDict = {
    'ibd-business':'http://feeds2.feedburner.com/BusinessRss'
#    'tech':'https://www.nasdaq.com/feed/rssoutbound?category=Technology'
#    'stocks' : 'https://www.nasdaq.com/feed/rssoutbound?category=Stocks'
}

for key, value in urlDict.items():
    print ('Processing ', key, '->', value)
    url = value

    json_feed  = feedparser.parse(url)

    # works
    entry = json_feed['entries'][0]
    # summary_detail prints too much info for IBD
    #print ("summary_detail: ", entry['summary_detail'])
    #print ("links: ",  entry['links'])#
    print ("link ====> " ,  entry['link'])
    #print ("title_detail", entry['title_detail'])
    print ("summary ====>", entry["summary"])
    if ('content' in entry):
        print ("content====>", entry["content"])

    #print (len(entry))
    print("")

    sys.exit(-1)
    for entry in json_feed['entries']:
        #print (entry['links']['href'])
        linksMap = entry['links'][0]
        
        print (linksMap['href'])
        #print (entry['summary_detail'])
        print ("Title: " + entry['title'])
        print ("Description: " + entry['description'])
        #print (entry['subtitle'])
        print ("----------\n")

#print (json_obj.feed.title)

#print (json_obj.feed.subtitle)

#print (json_obj['entries'])

#for i in json_obj['entries']:
#    print  i['summary']
#    print ('')

#print ('---')



#print ("hello")

