package com.fawry_api.fawry.Controller.Payment;

import com.fawry_api.fawry.Model.Payment.Wallet;

public class Funds implements FundsInterface{
   //make this class controller, remove wallet, remove println
    public String username;
    public Float amount;
    public Funds(Float amount,String username){
        this.username = username;

        this.amount = amount;
    }

    public Double addFunds(Float amount,String ccNum,Wallet w){
        w.c.pay(amount,ccNum);
        w.currentCredit+=amount;
        return w.currentCredit;

    }
}
