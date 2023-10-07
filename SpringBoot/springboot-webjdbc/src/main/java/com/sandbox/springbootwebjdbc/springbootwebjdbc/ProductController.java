package com.sandbox.springbootwebjdbc.springbootwebjdbc;

//import org.apache.log4j.LogManager;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    static final Logger logger = Logger.getLogger(ProductController.class.getName());

    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productRepository.findAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
    // READ
    @RequestMapping("/product/read/{id}")
    @ResponseBody
    public String readProduct(@PathVariable("id") long id) {
        Product product;
        try {
            product = productRepository.findOne(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return e.getMessage();
        }
        if (product == null) {
            String errorMessage = "No product found for id " + id;
            logger.info(errorMessage);
            return errorMessage;
        } else {
            return product.getProductId() + " : " + product.getName();
        }
    }
}
