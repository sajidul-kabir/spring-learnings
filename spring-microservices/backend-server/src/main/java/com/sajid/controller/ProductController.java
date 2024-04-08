package com.sajid.controller;

import com.sajid.dto.ProductDto;
import com.sajid.entity.Product;
import com.sajid.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
@ResponseBody
public class ProductController {

    private final ProductService productService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> listProducts = productService.getAllProducts();
        log.info("Retrieved {} products", listProducts.size());
        return ResponseEntity.status(HttpStatus.OK).body(listProducts);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertProduct(@RequestBody ProductDto productDto) {
        try {
            productService.insertNewProduct(productDto.getName(), productDto.getPrice());
            log.info("New product inserted successfully - name: {}, price: {}", productDto.getName(), productDto.getPrice());
            return ResponseEntity.status(HttpStatus.CREATED).build(); // Return 201 Created
        } catch (Exception e) {
            log.error("Error inserting new product - name: {}, price: {}", productDto.getName(), productDto.getPrice(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return 500 Internal Server Error
        }
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto) {
        log.info("updating...");
        try {
            productService.updateExistingProduct(productDto.getId(),productDto.getName(), productDto.getPrice());
            log.info("Product updated successfully - id: {}, name: {}, price: {}", productDto.getId(),productDto.getName(), productDto.getPrice());
            return ResponseEntity.status(HttpStatus.OK).build(); // Return 200 ok
        } catch (Exception e) {
            log.error("Error updating product - id: {}, name: {}, price: {}", productDto.getId(),productDto.getName(), productDto.getPrice(), e);
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build(); // Return 304 Not Modified
        }
    }

    @RequestMapping( method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(String id) {
        productService.deleteProduct(Integer.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/update-product", method = RequestMethod.GET)
    public ResponseEntity<Product> showEditForm(String id) {
        Product existingProduct = productService.getExistingProduct(Integer.valueOf(id));
        log.info("Fetched existing product - id: {}, name: {}, price: {}", existingProduct.getId(), existingProduct.getName(), existingProduct.getPrice());
        return ResponseEntity.status(HttpStatus.OK).body(existingProduct);
    }




}
