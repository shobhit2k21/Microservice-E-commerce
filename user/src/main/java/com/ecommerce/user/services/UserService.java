package com.ecommerce.user.services;

import com.ecommerce.user.dto.AddressDTO;
import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.dto.UserResponse;
import com.ecommerce.user.model.Address;
import com.ecommerce.user.model.User;
import com.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {                       //here all the request are handeled send by controller

    public void addUser(UserRequest userRequest) {     // gives service to createUser
      return;
    }

    private void updateUserFromRequest(User user, UserRequest userRequest) {
        return;
    }

    public List<UserResponse> fetchAllUsers() {
        return null;
    }


     public Optional<UserResponse> fetchUser(String id) { // Using java stream
         return null;

     }

     public Boolean UpdateUser(String id, UserRequest updateUserRequest) {
         return null;

     }

     private UserResponse mapToUserResponse(User user){
         return null;
     }
}
