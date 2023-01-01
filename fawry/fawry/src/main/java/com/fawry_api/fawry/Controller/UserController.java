package com.fawry_api.fawry.Controller;

import com.fawry_api.fawry.BSL.UserBSL;
import com.fawry_api.fawry.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Component
public class UserController {
    @Autowired
    ServiceController serviceController;
    UserBSL userBSL;
    UserController() {
        userBSL = new UserBSL();
    }
    @GetMapping(value = "user/signin/{email}/{password}")
    public String find(@PathVariable("email") String email, @PathVariable("password")String password) {
            return userBSL.find(email,password,serviceController);
    }
    @GetMapping(value = "user/signup/{user_name}/{email}/{password}")
    public String find(@PathVariable("user_name") String user_name,@PathVariable("email") String email, @PathVariable("password")String password) {
        return userBSL.find(user_name,email,password);
    }
    @PostMapping(value = "user/addFunds/{amount}/{creditcardnum}")
    public Double addFundsWallet(@PathVariable("amount")float amount,@PathVariable("creditcardnum")String creditcardNum) {
        return userBSL.addFundsWallet(amount,creditcardNum,serviceController);
    }
}
