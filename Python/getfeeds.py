#!/bin/python

import feedparser
# import sys

urlDict = {
    'ibd-business': 'http://feeds2.feedburner.com/BusinessRss',
    'nasdaq-tech':
    'https://www.nasdaq.com/feed/rssoutbound?category=Technology',
    'nasdaq-stocks': 'https://www.nasdaq.com/feed/rssoutbound?category=Stocks',
}

for key, value in urlDict.items():
    print('Processing ', key, '->', value)
    url = value
    json_feed = feedparser.parse(url)

    # for debugging
    # entry = json_feed['entries'][0]
    # summary_detail prints too much info for IBD
    # print ("summary_detail: ", entry['summary_detail'])
    # print ("links: ",  entry['links'])#
    # print("link ====> ", entry['link'])
    # print ("title_detail", entry['title_detail'])
    # print("summary ====>", entry["summary"])
    # if 'content' in entry:
    #    print("content====>", entry["content"])

    # print (len(entry))
    print("")

    with open(key + '-feedoutput.html', 'w', encoding='utf-8') as fo:
        fo.write("<html>")

        for entry in json_feed['entries']:
            # print("Link: " + entry['link'])
            # linksMap = entry['links'][0]
            # print(linksMap['href'])
            # print (entry['summary_detail'])
            fo.write("<a href=" + entry['link'] + ">" +
                     entry['title'] + "</a>")
            fo.write(entry['description'])
            # print (entry['subtitle'])
            fo.write("<br />")

        fo.write("</html>")

