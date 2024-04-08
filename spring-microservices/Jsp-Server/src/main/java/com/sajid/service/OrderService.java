package com.sajid.service;

import com.sajid.dto.OrderDto;
import com.sajid.dto.ProductDto;
import com.sajid.entity.Order;
import com.sajid.entity.Product;
import com.sajid.utils.BackendUrlUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RestTemplate restTemplate;
    private final String baseUrl = BackendUrlUtil.BASE_URL;
    public List<Order> getOrdersFromBackendService() {
            String resourceUrl = baseUrl+"/orders";
            ResponseEntity<List<Order>> response = restTemplate.exchange(
                    resourceUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Order>>() {}
            );
            return response.getBody();
        }

    public HttpStatus insertorderIntoBackendService(OrderDto orderDto) {
        String resourceUrl = baseUrl+"/orders";
        HttpEntity<OrderDto> requestEntity = new HttpEntity<>(orderDto);

        ResponseEntity<List<Product>> response = restTemplate.exchange(
                resourceUrl,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        return response.getStatusCode();
    }
}
