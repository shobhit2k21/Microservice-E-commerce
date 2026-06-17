package com.ecommerce.order.controller;

import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @McpTool(name = "Place_Order", description = "Placed or Create Order")
    public ResponseEntity<OrderResponse> createOrder(
            @RequestHeader("X-User-Id") String userId) {

        return orderService.createOrder(userId)
                .map(orderResponse -> new ResponseEntity<>(orderResponse, HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @McpTool(name = "Get_Order", description = "Get Order By Id")
    @GetMapping("/{id}")  // getting particular order by id
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        return orderService.fetchOrder(id).map(ResponseEntity::ok)   // this line is another approch of above code using streams
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
