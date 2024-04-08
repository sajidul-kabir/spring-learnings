package com.sajid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Order {

    private int id;
    private String customer_name;
    private String address;
    private String product;
    private double transaction;

    public Order(String customer_name, String address, String product, double transaction) {
        this.customer_name = customer_name;
        this.address = address;
        this.product = product;
        this.transaction = transaction;
    }


}
