package com.fawry_api.fawry.Controller.Payment;

import com.fawry_api.fawry.View.Payment.Wallet;

public class Funds implements FundsInterface{
   //make this class controller, remove wallet, remove println
    Float amount;
    Wallet w;
    public Funds(Wallet w,Float amount){
        this.w=w;
        this.amount = amount;
    }
    public Double addFunds(Float amount,String ccNum){
        w.c.pay(amount,ccNum);
        w.currentCredit+=amount;
        return w.currentCredit;

    }
}
