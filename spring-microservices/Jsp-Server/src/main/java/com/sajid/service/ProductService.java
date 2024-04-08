package com.sajid.service;

import com.sajid.dto.ProductDto;
import com.sajid.entity.Product;
import com.sajid.utils.BackendUrlUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final RestTemplate restTemplate;
    private final String baseUrl =BackendUrlUtil.BASE_URL;


    public List<Product> getProductsFromBackendService(){
            String resourceUrl = baseUrl+"/products";
            ResponseEntity<List<Product>> response = restTemplate.exchange(
                    resourceUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Product>>() {}
            );
            return response.getBody();
        }

    public HttpStatus insertProductIntoBackendService(ProductDto productDto) {
        String resourceUrl = baseUrl+"/products";
        HttpEntity<ProductDto> requestEntity = new HttpEntity<>(productDto);

        ResponseEntity<List<Product>> response = restTemplate.exchange(
                resourceUrl,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        return response.getStatusCode();
    }

    public HttpStatus updateProductInBackendService(ProductDto productDto) {
        String resourceUrl = baseUrl+"/products";
        HttpEntity<ProductDto> requestEntity = new HttpEntity<>(productDto);

        ResponseEntity<Product> response = restTemplate.exchange(
                resourceUrl,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Product>() {}
        );
        System.out.println(response);
        return response.getStatusCode();
    }

    public Product getExistingProduct(String id) {
        String resourceUrl = baseUrl+"/products/update-product?id="+id;
        ResponseEntity<Product> response = restTemplate.exchange(
                resourceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Product>() {}
        );
        return response.getBody();

    }

    public HttpStatus deleteProductInBackendService(String id) {
        String resourceUrl = baseUrl+"/products?id="+id;
        ResponseEntity<Product> response = restTemplate.exchange(
                resourceUrl,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Product>() {}
        );
        return response.getStatusCode();
    }
}
