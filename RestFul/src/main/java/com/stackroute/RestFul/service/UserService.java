package com.stackroute.RestFul.service;

import com.stackroute.RestFul.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public void saveUser(User user);

    public List<User> getAllUsers();

    public Optional<User> getById(Integer id);
    public void deleteUserById(Integer id);
    public String updateById(Integer id, String phone);
    public void updateByIdPut(User user);
    public double calculateUserQuote(String vehicleType, Integer engineSize,Integer vehicleValue, Integer additionalDrivers,
                                 String commercialUse, String outsideStateUse);
}
