package com.sandbox.springbootwebjdbc.springbootwebjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Product product = new Product();
        product.setProductId(rs.getInt("ProductID"));
        product.setName(rs.getString("Name"));
        product.setProductNumber(rs.getString("ProductNumber"));

        return product;
    }
}

/**
 *
 */
@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<Product> findAllProducts() {
        List <Product> productList = jdbcTemplate.query("SELECT * FROM Production.Product",
                new ProductRowMapper());

        System.out.println("Found: " + productList.size());
        return productList;
    }

    @Transactional(readOnly=true)
    public Product findOne(long id) {
        Object [] parameters = new Object [] { id };
        Product product =
                jdbcTemplate.queryForObject("SELECT * FROM Production.Product where ProductId = ?",
                        parameters, new ProductRowMapper());

        System.out.println("Found: " + product.getProductId());
        return product;
    }
}
