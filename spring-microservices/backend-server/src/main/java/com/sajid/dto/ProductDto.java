package com.sajid.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private Double price;

}
