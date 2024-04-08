package com.sajid.controller;

import com.sajid.dto.OrderDto;
import com.sajid.entity.Order;
import com.sajid.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

     private final OrderService orderService;

    @RequestMapping
    public ResponseEntity<List<Order>> listAllorders(){
      List<Order> orders= orderService.getAllOrders();
        log.info("Retrieved {} orders", orders.size());
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Void> insetNewOrder(@RequestBody OrderDto orderDto){
        orderService.insertNewOrder(orderDto.getCustomer_name(),orderDto.getProduct(),orderDto.getTransaction(),orderDto.getAddress());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
