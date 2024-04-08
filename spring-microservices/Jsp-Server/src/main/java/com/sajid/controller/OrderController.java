package com.sajid.controller;

import com.sajid.dto.OrderDto;
import com.sajid.dto.ProductDto;
import com.sajid.entity.Order;
import com.sajid.entity.Product;
import com.sajid.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String listAllOrders(Model model) {
        List<Order> listOrders = orderService.getOrdersFromBackendService();
        model.addAttribute("listOrders", listOrders);
        log.info(listOrders.toString());
        return "order/order-list";
    }
    @RequestMapping(method = RequestMethod.POST)
    public void insertNeworder(@RequestBody OrderDto orderDto) throws Exception {
        HttpStatus statusCode = orderService.insertorderIntoBackendService(orderDto);
        if (statusCode != HttpStatus.CREATED) {
            throw new Exception("Error: Unexpected status code received: " + statusCode);
        }
    }

    @RequestMapping(value = "/new-order", method = RequestMethod.GET)
    public String newOrderForm(){
        return "order/new-order";
    }
}
