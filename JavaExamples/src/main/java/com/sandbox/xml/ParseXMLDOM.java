package com.sandbox.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Define a Product class with attributes that can used to process later
 */
class Product implements Comparable {
    String name;
    BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public int compareTo(Object p) {
        Product prod = (Product)p;
        return name.compareTo(prod.getName());
    }
    // Method to print the product name
    public String toString() {
        // a BigDecimal can be printed with a %s
        String productString = String.format("%s:%s", name, price);
        return productString;
    }

}

/**
 * Class which will read in an XML File and process
 */
public class ParseXMLDOM {

    /*
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<product_data>
	<product>
		<name>Sterling</name>
		<price>89.00</price>
	</product>
	</product>
</product_data>
     */
    private static void processFeedFile(String fileName) {
        try {
            List<Product> productList = new ArrayList<>();
            // construct a Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the xml file
            Document document = builder.parse(new File( fileName ));
            // start processing from root
            Element root = document.getDocumentElement();
            // fetch the list of Product nodes
            NodeList nodeList = root.getElementsByTagName("product");

            if (nodeList != null) {

                for(int i=0; i<nodeList.getLength(); i++) {
                    // Extract a Product node and fetch attributes.
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element)node;
                        String name = element.getElementsByTagName("name").item(0).getTextContent();
                        String price = element.getElementsByTagName("price").item(0).getTextContent();

                        BigDecimal priceBigDecimal = new BigDecimal(price);

                        Product product = new Product(name, priceBigDecimal);
                        productList.add(product);
                    }

                    if (node.getNodeType() == Node.TEXT_NODE) {
                        //System.out.println(node.getNodeValue());
                    }
                }
            }

            // Print list of Products
            if (productList.size() > 0) {
/*                productList
                        .stream()
                        .forEach(System.out::println);*/
                productList
                        .stream()
                        .filter(p -> p.getName().contains("Bracelet") )
                        .filter(p -> p.getPrice().doubleValue() <= 39.00)
                        .sorted()
                        .forEach(System.out::println);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    } // processFeedFile

    private static void processOrderStatus (String fileName) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File( fileName ));

            Element root = document.getDocumentElement();

            NodeList nodeList = root.getElementsByTagName("Orders");

            nodeList = nodeList.item(0).getChildNodes();
            if (nodeList != null) {

                for(int i=0; i<nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element)node;
                        System.out.println(element.getElementsByTagName("OrderNumber").item(0).getTextContent());
                    }
                    if (node.getNodeType() == Node.TEXT_NODE) {
                        //System.out.println(node.getNodeValue());
                    }
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
}

    public static void main(String [] args) {
        String fileName = "C:\\tmp\\request.xml";

        processOrderStatus(fileName);

        fileName = "c:\\tmp\\feed.xml";
        processFeedFile(fileName);
    }
}
