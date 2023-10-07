import urllib3, json

url = 'url_to_use'

data = '''
{
    "success": true,
    "message": "",
    "result": [{
        "MarketCurrency": "LTC",
        "BaseCurrency": "BTC",
        "MarketCurrencyLong": "Litecoin",
        "BaseCurrencyLong": "Bitcoin",
        "MinTradeSize": 0.00000001,
        "MarketName": "BTC-LTC",
        "IsActive": true,
        "Created": "2014-02-13T00:00:00",
        "Notice": null,
        "IsSponsored": null,
        "LogoUrl": "https://i.imgur.com/R29q3dD.png"
    },
    {
        "MarketCurrency": "DOGE",
        "BaseCurrency": "BTC",
        "MarketCurrencyLong": "Dogecoin",
        "BaseCurrencyLong": "Bitcoin",
        "MinTradeSize": 0.00000001,
        "MarketName": "BTC-DOGE",
        "IsActive": true,
        "Created": "2014-02-13T00:00:00",
        "Notice": null,
        "IsSponsored": null,
        "LogoUrl": "https://i.imgur.com/e1RS4Hn.png"
    }]
}'''

#urlFile = urllib3.urlopen(url)

jsonList = json.loads(data)

for item in jsonList['result']:
    print (item['MarketName'])