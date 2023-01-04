package com.fami.demo.controller;


import com.fami.demo.model.UserModel;
import com.fami.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserModel userModel) {
        return new ResponseEntity(userService.saveUser(userModel), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long idUser) {
        return new ResponseEntity(userService.getUser(idUser), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        Boolean response = userService.deleteUser(id);
        if (response) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
