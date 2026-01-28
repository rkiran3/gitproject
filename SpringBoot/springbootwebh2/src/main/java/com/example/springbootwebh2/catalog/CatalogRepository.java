package com.example.springbootwebh2.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	class CatalogRowMapper implements RowMapper<Catalog> {
		
		@Override
		public Catalog mapRow(ResultSet rs, int rowNum) throws SQLException {
			Catalog catalog = new Catalog();
			catalog.setId(rs.getLong("id"));
			catalog.setName(rs.getString("name"));
			return catalog;
		}
	}
	
	public List<Catalog> findAll() {
		return jdbcTemplate.query("select * from catalog", new CatalogRowMapper());
	}
	
	public Catalog findById(long id) {
		return jdbcTemplate.queryForObject("select * from student where id=?", new Object[] {id},
				new BeanPropertyRowMapper<Catalog>(Catalog.class));
				
	}
	
	
	
}
