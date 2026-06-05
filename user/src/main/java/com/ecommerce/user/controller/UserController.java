package com.ecommerce.user.controller;

import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.dto.UserResponse;
import com.ecommerce.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // ese GetMapping , PutMapping baar baar /api/users nhi likhna padega
@RequiredArgsConstructor

public class UserController {

    private final UserService userService; // all functions are present in UserService class

    @McpTool(name = "Get_all_Users", description = "This gives the list of all Users")
    @GetMapping    // it maps with url  // getting all users
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    @McpTool(name = "Get_User_By_Id", description = "This give the User of particular id")
    @GetMapping("/{id}")  // getting particular user by id
    public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
        return userService.fetchUser(id).map(ResponseEntity::ok)   // this line is another approch of above code using streams
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @McpTool(name = "Create_User", description = "It creates and add the User")
    @PostMapping  // creating or adding user using Postman
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        return ResponseEntity.ok("User Added successfully");
    }

    @McpTool(name = "Update_User_By_Id", description = "This updates the User of particular id")
     @PutMapping("/{id}")
     public ResponseEntity<String> PutUser(@PathVariable String id,  @RequestBody UserRequest userRequest) {
        boolean updated = userService.UpdateUser(id, userRequest);
          if(updated) {
              return ResponseEntity.ok("User Updated Successfully");
          }
          return ResponseEntity.notFound().build();
     }

}
