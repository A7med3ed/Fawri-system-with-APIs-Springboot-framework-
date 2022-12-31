package com.fawry_api.fawry.Model;

import com.fawry_api.fawry.Controller.Observers.Observers;
import com.fawry_api.fawry.View.Payment.Wallet;

import java.util.ArrayList;


public class User implements Observers {


    public User(String user_name,String email,String password) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        wallet.currentCredit= Float.valueOf(0);
        userId = userIdCount;
        userIdCount++;
    }
    public User() {
    }
    public ArrayList <Operation> operationlist = new ArrayList<Operation>();
    public String user_name;
    public String email;
    public String password;
    public Wallet wallet = new Wallet();
    static int userIdCount = 0;
    int userId;
//    public Double discout;
//    public String credit_num;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String update(String massage) {
        return massage;
    }



}