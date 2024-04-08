package com.sajid.utils;

import com.sajid.dto.ProductDto;
import com.sajid.entity.Product;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductRowMapper  implements RowMapper<Product> {


    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double price = rs.getDouble("price");
        return new Product(id, name, price);
    }

}
