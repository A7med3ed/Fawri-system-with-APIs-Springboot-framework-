package com.fawry_api.fawry.Model.Payment;

import com.fawry_api.fawry.Controller.Payment.Payment;

public class Cash implements Payment {
    public String pay(double amount){
        return String.format("paying in cash: %s",(amount));
    }
}
