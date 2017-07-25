package com.sandbox.springbootwebjdbc.springbootwebjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));

        return user;
    }
}
@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<User> findAll() {
        List <User> userList = jdbcTemplate.query("SELECT * FROM USERS",
                new UserRowMapper());

        System.out.println("Found: " + userList.size() );
        return userList;
    }

    @Transactional(readOnly=true)
    public User findOne(long id) {
        Object [] parameters = new Object [] { id };
        User user =
                jdbcTemplate.queryForObject("SELECT * FROM USERS where Id = ?",
                parameters, new UserRowMapper());

        System.out.println("Found: " + user.getId() );
        return user;
    }
}
