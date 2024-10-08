package com.order_service.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.common_masters.common.OrderDTO;
import com.order_service.services.OrderService;

@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping("/place-order")
  public ResponseEntity<Map<Object, Object>> placeOrder(@RequestBody OrderDTO order) {

    if (order == null) {
      return ResponseEntity.badRequest().body(null);
    }

    System.out.println("\n\n\n Order : " + order);
    String resp = orderService.placeOrder(order);

    Map<Object, Object> result = new HashMap<>();
    result.put("response", resp);
    result.put("status", "success");
    result.put("message", "Order placed successfully");

    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

}
