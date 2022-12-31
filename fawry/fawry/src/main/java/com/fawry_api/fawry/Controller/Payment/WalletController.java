package com.fawry_api.fawry.Controller.Payment;

import org.springframework.stereotype.Component;

@Component
public class WalletController {
    public double compare(double cc, double amount){
        if(cc < amount || cc ==0){
            return cc;
        }
        else {
            cc-=amount;
            return cc;
        }


    }
}
