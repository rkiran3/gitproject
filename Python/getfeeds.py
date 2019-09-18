#!/bin/python

import feedparser
import sys

urlDict = {
    
    'key':'url of feed'
}

for key, value in urlDict.items():
    print ('Processing ', key, '->', value)
        
    url = value

    json_feed  = feedparser.parse(url)
    # works
    #print (json_feed['entries'][0]['summary_detail'])
    #print (json_feed['entries'][0]['links'])
    #print len(json_feed['entries'])

    #sys.exit(-1)
    for entry in json_feed['entries']:
        #print (entry['links'])
        #print (entry['summary_detail'])
        print ("Title: " + entry['title'])
        print (entry['description'])
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

