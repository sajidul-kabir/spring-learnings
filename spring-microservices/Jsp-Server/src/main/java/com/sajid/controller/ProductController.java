package com.sajid.controller;


import com.sajid.dto.ProductDto;
import com.sajid.entity.Product;
import com.sajid.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String listAllProducts(Model model) {
        List<Product> listProducts = productService.getProductsFromBackendService();
        model.addAttribute("listProducts", listProducts);
        log.info(listProducts.toString());
        return "product/product-list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertNewProduct(@RequestBody ProductDto productDto) throws Exception {
        HttpStatus statusCode = productService.insertProductIntoBackendService(productDto);
        if (statusCode != HttpStatus.CREATED) {
            throw new Exception("Error: Unexpected status code received: " + statusCode);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateProduct(@RequestBody ProductDto productDto) throws Exception {
        System.out.println(productDto);
            HttpStatus statusCode =   productService.updateProductInBackendService(productDto);

            if (statusCode != HttpStatus.OK) {
                throw new Exception("Error: Unexpected status code received: " + statusCode);
            }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteProduct(@RequestParam String id) throws Exception {
        HttpStatus statusCode =  productService.deleteProductInBackendService(id);

        if (statusCode != HttpStatus.OK) {
            throw new Exception("Error: Unexpected status code received: " + statusCode);
        }
    }

    @RequestMapping(value = "/new-product", method = RequestMethod.GET)
    public String newproductForm() {
        log.info("Accessing New Product form");
        return "product/new-product";
    }
    @RequestMapping(value = "/update-product", method = RequestMethod.GET)
    public String showEditForm(@RequestParam String id, Model model) {
        Product existingProduct = productService.getExistingProduct(id);
        log.info("Fetched existing product - id: {}, name: {}, price: {}", existingProduct.getId(), existingProduct.getName(), existingProduct.getPrice());
        model.addAttribute("product", existingProduct);
        return "product/new-product";
    }



}
