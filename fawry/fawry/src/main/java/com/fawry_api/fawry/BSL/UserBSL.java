package com.fawry_api.fawry.BSL;

import com.fawry_api.fawry.Controller.Payment.Funds;

import com.fawry_api.fawry.Controller.ServiceController;
import com.fawry_api.fawry.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Service
public class UserBSL {
    public ArrayList<User> arr = new ArrayList<User>();

    public String find(String email, String password, ServiceController serviceController) {
        for (int x = 0; x < arr.size(); x++) {
            if (Objects.equals(arr.get(x).password, password) && Objects.equals(arr.get(x).email, email)) {
                ServiceBSL.user = arr.get(x);
                String s = serviceController.notifyRefund();
                System.out.println(s);
                return "Successful \n "+ s;
            } else
                continue;
        }
        return "Failed";
    }

    public String find(String user_name,String email, String password) {
        for (int x = 0; x < arr.size(); x++) {
            if (Objects.equals(arr.get(x).email, email) || Objects.equals(arr.get(x).user_name, user_name)) {
                return "Failed";
            } else {
                User u = new User(user_name, email, password);
                arr.add(u);
                ServiceBSL.user = arr.get(arr.size()-1);
                return "Successful";
            }
        }

        if (arr.size() == 0) {
            User u = new User(user_name, email, password);
            arr.add(u);
            ServiceBSL.user = arr.get(0);
            return "Successful" ;
        }
        return "Failed";

    }
    public Double addFundsWallet(float amount,String creditcardNum,ServiceController serviceController) {
        Funds funds = new Funds(amount,ServiceBSL.user.user_name);
        serviceController.adminControlleront.adminBSL.addToWalletTransactions.add(funds);
        return funds.addFunds(amount,creditcardNum,ServiceBSL.user.wallet);
    }

}
