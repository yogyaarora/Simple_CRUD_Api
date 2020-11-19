package com.example.Simple_CRUD_Api.controller;

import com.example.Simple_CRUD_Api.beans.User;
import com.example.Simple_CRUD_Api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/allusers")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/newuser")
    String newUser(@Valid @RequestBody User newUser){
        userRepository.save(newUser);
        return "User added successfully";
    }

    @PutMapping("/updateuser/{id}")
    String updateUser(@Valid @RequestBody User newUser,@PathVariable("id")int id) throws Exception {
        User user=userRepository.findById(id).orElseThrow(()->new Exception("User not found"));
        user.setName(newUser.getName());
        user.setPassword(newUser.getPassword());
        user.setUsername(newUser.getUsername());
        user.setAge(newUser.getAge());
        userRepository.save(user);
        return "User updated sucessfully";
    }

    @DeleteMapping("/deleteuser/{id}")
    String deleteUser(@PathVariable("id") int id){
        userRepository.deleteById(id);
        return "User removed successfully";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
