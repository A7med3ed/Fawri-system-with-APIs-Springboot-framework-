package com.fawry_api.fawry.View.Payment;

import com.fawry_api.fawry.Controller.Payment.WalletController;
import com.fawry_api.fawry.Controller.Payment.Payment;

public class Wallet implements Payment {
    WalletController walletController = new WalletController();
    public double currentCredit = 0.0;
    public CreditCard c =new CreditCard();
    public String pay(double amount){
        double cc ;
        cc = walletController.compare(currentCredit,amount);
        if(currentCredit == cc){
            return "Failed";
        }
        else if (currentCredit > cc){
            currentCredit = cc;
            return String.format("Successful %s",(amount));
        }
        return "Failed";
    }
}