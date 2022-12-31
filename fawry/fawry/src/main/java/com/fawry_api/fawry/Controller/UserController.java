package com.fawry_api.fawry.Controller;

import com.fawry_api.fawry.Controller.Observers.Subject;
import com.fawry_api.fawry.Controller.Payment.Funds;
import com.fawry_api.fawry.Model.Operation;
import com.fawry_api.fawry.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;
@RestController
@Component
public class UserController {
    @Autowired
    ServiceController serviceController;
    protected ArrayList<User> arr = new ArrayList<User>();
   // AdminController adminControlleront = AdminController.getInstance();
    //protected int user;
    private static UserController uc;
    UserController() {
    }
    @GetMapping(value = "user/signin/{email}/{password}")
    public String find(@PathVariable("email") String email, @PathVariable("password")String password) {
        for (int x = 0; x < arr.size(); x++) {
            if (Objects.equals(arr.get(x).password, password) && Objects.equals(arr.get(x).email, email)) {
                ServiceController.user = arr.get(x);
                String s = serviceController.notifyRefund();
                System.out.println(s);
                return "Successful \n "+ s;
            } else
                continue;
        }
        return "Failed";
    }

    @GetMapping(value = "user/signup/{user_name}/{email}/{password}")
    public String find(@PathVariable("user_name") String user_name,@PathVariable("email") String email, @PathVariable("password")String password) {
        for (int x = 0; x < arr.size(); x++) {
            if (Objects.equals(arr.get(x).email, email) || Objects.equals(arr.get(x).user_name, user_name)) {
                return "Failed";
            } else {
                User u = new User(user_name, email, password);
                arr.add(u);
                ServiceController.user = arr.get(arr.size()-1);
                return "Successful";
            }
        }

        if (arr.size() == 0) {
            User u = new User(user_name, email, password);
            arr.add(u);
            ServiceController.user = arr.get(0);
            return "Successful" ;
        }
        return "Failed";

    }
    @PostMapping(value = "user/addFunds/{amount}/{creditcardnum}")
    public Double addFundsWallet(@PathVariable("amount")float amount,@PathVariable("creditcardnum")String creditcardNum) {
        Funds funds = new Funds(ServiceController.user.wallet,amount);
        serviceController.adminControlleront.addToWalletTransactions.add(funds);
        return funds.addFunds(amount,creditcardNum);
    }
}
