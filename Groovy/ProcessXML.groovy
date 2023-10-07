
// This class represents an Order Export Object
class OrderExport {
	String orderCode
	String promotionCode
	BigDecimal tax
	
}


// this class will return all filenames that contain a pattern
class FileFilter implements FilenameFilter {
       public boolean accept (File f, String filename) {
             return filename.contains( "2016" )
      }
}


// Start program which expects a folder name
def folderName = ""
if (args.length > 0) {
    folderName = args[0]
} else {
    println ("Please provide a folder name as argument")
    System.exit(-1)
}

// This method will process all Order Export files and then return a List of Orders 
def getOrderExportList(String folderName) {
	Map orderExportMap = 


	// read folder and filter all files that match the pattern
	// use listFiles which gives us the File Object to work with
	new File(folderName ).listFiles( new FileFilter()).each { filteredFileName ->

		// only process valid files.
		if (filteredFileName.length() > 0) {
			// getPath() returns full path of file object
			//println filteredFileName.getPath()
					
			def orderExportXML = new XmlSlurper().parse(filteredFileName.getPath())
			
			for (orderCollection in orderExportXML.OrderCollection) {
				println "processing: ${orderCollection.OrderCode}"
				// Construct an Order Export Object 
				new OrderExport(orderCode: orderCollection.OrderCode)
				
				def promoCodeText = orderCollection.PromoCode.text()
				//println "promo code size: " + promoCode.size()
				if (promoCodeText.size() > 0)
					println "Promo Code : ${promoCodeText}"	
			}
		}
	}

}

getOrderExportList(folderName)