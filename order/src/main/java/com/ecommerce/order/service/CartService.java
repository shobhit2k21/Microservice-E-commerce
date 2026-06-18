package com.ecommerce.order.service;

import com.ecommerce.order.clients.ProductServiceClient;
import com.ecommerce.order.clients.UserServiceClient;
import com.ecommerce.order.dto.CartItemRequest;
import com.ecommerce.order.dto.ProductResponse;
import com.ecommerce.order.dto.UserResponse;
import com.ecommerce.order.model.CartItem;
import com.ecommerce.order.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    // making objects of repo to find the user, product, item in database
    private final CartItemRepository cartRepository;
    private final ProductServiceClient productServiceClient;
    private final UserServiceClient userServiceClient;

    public boolean addToCart(String userId, CartItemRequest request) {
        ProductResponse productResponse = productServiceClient.getProductDetails(request.getProductId());
        if(productResponse == null || productResponse.getStockQuantity() < request.getQuantity())  // checking whether product exist or not in database
            return false;

        UserResponse userResponse = userServiceClient.getUserDetails(userId);
        if(userResponse == null)  // is User exist ? or is it valid userId?
            return false;

//        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
//           if(userOpt.isEmpty())
//               return false;  // is User exist ? or is it valid userId?
//
//          User user = userOpt.get();

        CartItem existingCartItem = cartRepository.findByUserIdAndProductId(userId, request.getProductId());
        if(existingCartItem != null) {
            // Update the quantity and price
            existingCartItem.setQuantity(existingCartItem.getQuantity() + request.getQuantity());
            // existingCartItem.setPrice(BigDecimal.valueOf(1000.00));
            existingCartItem.setPrice(productResponse.getPrice().multiply(BigDecimal.valueOf(existingCartItem.getQuantity())));
            cartRepository.save(existingCartItem);
        } else {
            // Create new cartItem
            CartItem cartItem = new CartItem();
            cartItem.setUserId(userId);
            cartItem.setProductId(request.getProductId());
            cartItem.setQuantity(request.getQuantity());
            // cartItem.setPrice(BigDecimal.valueOf(1000.00));
            cartItem.setPrice(productResponse.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())));
            cartRepository.save(cartItem);
        }

        return true;
    }

    public boolean removeFromCart(String userId, String productId) {
        CartItem cartItem = cartRepository.findByUserIdAndProductId(userId, productId);

        if(cartItem != null) {
            cartRepository.delete(cartItem);
            return true;
        }
        return false;
    }

    public List<CartItem> getCart(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public void clearCart(String userId) {
        cartRepository.deleteByUserId(userId);

    }
}
