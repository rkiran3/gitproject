def xmlText = '''
<Items>
	<Item>
		<Name>TestItem</Name>
	</Item>
</Items>

'''
				
// Returns a GPath, if xml is updated, entire tree needs
// to be evaluated
def itemXML = new XmlSlurper().parseText(xmlText)
assert "TestItem".equals(itemXML.Item.Name.text())


// Returns a Node object when parsing XML
def itemXMLParser = new XmlParser().parseText(xmlText)
assert "TestItem".equals(itemXMLParser.Item.Name.text())