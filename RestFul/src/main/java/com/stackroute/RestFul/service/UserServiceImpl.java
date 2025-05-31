package com.stackroute.RestFul.service;

import com.stackroute.RestFul.model.User;
import com.stackroute.RestFul.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private double vehicleTypeFactor, engineSizeFactor;

    //Constructor based autoWiring DI
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    // Save data to H2 memory
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    //Get all driver data

    @Override
    public List<User> getAllUsers() {
        List<User> userDetails=userRepository.findAll();
        return userDetails;
    }

     // Get Driver details by id
    @Override
    public Optional<User> getById(Integer id) {
        Optional<User> userById = userRepository.findById(id);
        return userById;
    }

    // delete driver details by id
    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    //update new phone number by using driver id

    @Override
    public String updateById(Integer id, String phone) {
        Optional<User> userById = userRepository.findById(id);
        if(userById.isPresent()) {  // optional we are using for "null" check
            User user = userById.get();
           // String str = Integer.parseInt(phone);
            //System.out.println("irfan"+user.getPhone());
            user.setPhone(phone);
            userRepository.save(user);
            return "user updated successfully";
        } else {
            return "User with id:"+id+" doesn't exist in system";
        }
    }

    // update whole driver body by using PUT method
    @Override
    public void updateByIdPut(User user) {
        userRepository.save(user);
    }

    // calculate insurance quote amount as per driver input

    @Override
    public double calculateUserQuote(String vehicleType, Integer engineSize, Integer vehicleValue, Integer additionalDrivers,String commercialUse, String outsideStateUse) {
           double result = 100 * vehicleTypeFactor(vehicleType) * engineSizeFactor(engineSize)*vehicleValueFactor(vehicleValue)*additionalDriversFactor(additionalDrivers)*commercialUseFactor(commercialUse) * outsideStateUseFactor(outsideStateUse);
                return result;
    }

    public double vehicleTypeFactor(String vehicleType) {
        try {
            switch (vehicleType) {
                case "Cabriolet":
                    vehicleTypeFactor = 1.3;
                    break;
                case "Coupe":
                    vehicleTypeFactor = 1.4;
                    break;
                case "Estate":
                    vehicleTypeFactor = 1.5;
                    break;
                case "Hatchback":
                    vehicleTypeFactor = 1.6;
                    break;
                default:
                    vehicleTypeFactor = 1.7;
                    break;
            }
        } catch (Exception e) {
            System.out.println("invalid vehicle type");
        }
        return vehicleTypeFactor;
    }

    public double engineSizeFactor(Integer engineSize) {
        try {
            switch (engineSize) {
                case 1000:
                    engineSizeFactor = 1.0;
                    break;
                case 1600:
                    engineSizeFactor = 1.6;
                    break;
                case 2000:
                    engineSizeFactor = 2.0;
                    break;
                case 2500:
                    engineSizeFactor = 2.5;
                    break;
                case 3000:
                    engineSizeFactor = 3.0;
                    break;
                default:
                    engineSizeFactor = 3.5;
                    break;
            }
        } catch (Exception e) {
            System.out.println("invalid engine size");
        }
        return engineSizeFactor;
    }

    public double vehicleValueFactor(Integer vehicleValue) {
        if (vehicleValue <= 5000) {
            return 1.0;
        } else {
            return 1.2;
        }
    }

    public double additionalDriversFactor(Integer additionalDrivers) {
        if (additionalDrivers <= 2) {
            return 1.1;
        } else {
            return 1.2;
        }
    }

    public double commercialUseFactor(String commercialUse) {
        if (commercialUse.equalsIgnoreCase("Yes")) {
            return 1.1;
        } else {
            return 1.0;
        }
    }

    public double outsideStateUseFactor(String outsideStateUse) {
        if (outsideStateUse.equalsIgnoreCase("Yes")) {
            return 1.1;
        } else {
            return 1.0;
        }
    }

}
