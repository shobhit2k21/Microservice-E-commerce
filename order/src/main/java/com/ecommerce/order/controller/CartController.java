package com.ecommerce.order.controller;

import com.ecommerce.order.dto.CartItemRequest;
import com.ecommerce.order.model.CartItem;
import com.ecommerce.order.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor

public class CartController {

    private final CartService cartService;

    @PostMapping
    @McpTool(name = "Add_to_Cart", description = "It add items into the cart of particular User Id")
    public ResponseEntity<String> addToCart(
              @RequestHeader("X-User-Id") String userId,
              @RequestBody CartItemRequest request) {

        if(!cartService.addToCart(userId, request)) { // if user or ProductRequest are not valid
          return ResponseEntity.badRequest().body("Product Out of Stock or User Not Found");
        }

        return ResponseEntity.ok().body("Item added Successfully");
     //   return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/item/{productId}")
    @McpTool(name = "Delete_from_Cart", description = "It delete or removes product_item by its id from the cart of particular User Id")
    public ResponseEntity<Void> removeFromCart(
             @RequestHeader("X-User-Id") String userId,
             @PathVariable String productId) {

        boolean deleted = cartService.removeFromCart(userId, productId);

        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

     @GetMapping
     @McpTool(name = "Get_All_Cart_Items", description = "It gives the whole list of cartItems")
     public ResponseEntity<List<CartItem>> fetchCart(
             @RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }
}
