package com.fawry_api.fawry.Model.Payment;

import com.fawry_api.fawry.Controller.Payment.Payment;

import java.util.Scanner;

public class CreditCard implements Payment {
    public String pay(double amount,String ccNum){
        return "Successful {}".formatted(amount);
    }

    @Override
    public String pay(double amount) {
        return String.format("Successful %s",amount);
    }
}