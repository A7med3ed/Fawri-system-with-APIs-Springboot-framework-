package com.fawry_api.fawry.View.Payment;

import com.fawry_api.fawry.Controller.Payment.Payment;

import java.util.Scanner;

public class CreditCard implements Payment {
    Scanner myobj =new Scanner(System.in);
    public String pay(double amount,String ccNum){
        return "Successful {}".formatted(amount);
    }

    @Override
    public String pay(double amount) {
        return String.format("Successful %s",amount);
    }
}