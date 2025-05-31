package com.stackroute.RestFul.controller;

import com.stackroute.RestFul.model.User;
import com.stackroute.RestFul.service.UserService;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/")
public class UserController {

    private UserService userService;

    //Constructor based AutoWiring
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/driverDetails")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
       // RestTemplate restTemplate;
       // restTemplate.postForEntity("http","http","data");
        try {
            System.out.println("Enter into post method");
            String vehicleType =user.getModel();
            Integer engineSize=Integer.valueOf(user.getEngine());
            Integer vahicleValue=Integer.valueOf(user.getMarketValue());
            Integer additionalDrivers=Integer.valueOf(user.getDriver());
            String commercialUse=user.getCommercial();
            String outsideStateUse=user.getOutstate();
            double calculateResult= userService.calculateUserQuote(vehicleType, engineSize,vahicleValue,additionalDrivers
                    ,commercialUse,outsideStateUse);
            System.out.println("Calculated final quote ammount: "+calculateResult);
            user.setFinalQuoteAmount(calculateResult);

            userService.saveUser(user);
            responseEntity = new ResponseEntity<>("User stored successfully", HttpStatus.OK);
        } catch(Exception exc) {
            responseEntity = new ResponseEntity<>("User not saved due to internal error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/driverDetails")
    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity responseEntity;
        try {
            List<User> allUsers = userService.getAllUsers();
            responseEntity = new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/driverDetails/{id}")
    public ResponseEntity<?> getByID(@PathVariable Integer id){
        ResponseEntity responseEntity;
        try {
            Optional<User> userById = userService.getById(id);
            responseEntity = new ResponseEntity<>(userById, HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @PatchMapping("/driverDetails/{id}/{phone}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @PathVariable String phone){
        ResponseEntity responseEntity;
        try{
            System.out.println("New phone number: "+phone);
            String message = userService.updateById(id, phone);
            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/driverDetails")
    public ResponseEntity<?> updateById(@RequestBody User user){
        ResponseEntity responseEntity;
        try{
            userService.updateByIdPut(user);
            responseEntity = new ResponseEntity<>("updated successfully", HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("driverDetails/{id}")
    public void deleteById(@PathVariable Integer id){
        userService.deleteUserById(id);
    }

}
