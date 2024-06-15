package com.Spring_Data_Jpa.Controller;

import com.Spring_Data_Jpa.Entity.AadharCard;
import com.Spring_Data_Jpa.Entity.User;
import com.Spring_Data_Jpa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    @Autowired
    UserRepository userRepository;


    @PostMapping("/addUser")
    public String addUser(@RequestBody User user, AadharCard aadharCard) {

        // Ensure both sides of the relationship are properly set
        if (user.getAadharCard() != null) {
            aadharCard = user.getAadharCard();
            aadharCard.setUser(user); // Set the user in the AadharCard
        }
        userRepository.save(user);
        return "User and AadharCard saved successfully!";
    }
}


