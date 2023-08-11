package com.example.carSale.Web;

import com.example.carSale.entity.User;
import com.example.carSale.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    @GetMapping("/{Id}")
    public ResponseEntity<String>  findbyId(@PathVariable Integer id){
        return new ResponseEntity<>(userService.getUser(id).getUsername(), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<User> creatUser(@RequestBody User user){
        userService.saveUsername(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
