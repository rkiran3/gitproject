#!/bin/python

import feedparser
import sys

url = 'http://feeds2.feedburner.com/ManagementRss'

json_feed  = feedparser.parse(url)
# works
#print (json_feed['entries'][0]['summary_detail'])
#print (json_feed['entries'][0]['links'])
#print len(json_feed['entries'])

#sys.exit(-1)
for entry in json_feed['entries']:
    print (entry['links'])
    #print (entry['summary_detail'])
    print (entry['title'])
    print (entry['content'])
    print ("----------\n")

#print (json_obj.feed.title)

#print (json_obj.feed.subtitle)

#print (json_obj['entries'])

#for i in json_obj['entries']:
#    print  i['summary']
#    print ('')

#print ('---')



#print ("hello")

