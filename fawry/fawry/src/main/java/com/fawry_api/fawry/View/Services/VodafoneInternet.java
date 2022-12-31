package com.fawry_api.fawry.View.Services;

import com.fawry_api.fawry.Controller.Services.InternetPaymentServices;
import com.fawry_api.fawry.Model.Form;

import java.util.Scanner;

public class VodafoneInternet extends InternetPaymentServices {
    Scanner myobj =new Scanner(System.in);

    public VodafoneInternet(){
        obj =new Form();

    }

    @Override
    public String getServiceName() {
        return "Vodafone Internet";
    }
//    public void getinfo(){
//        System.out.println("enter your phone number: ");
//        obj.phoneNumber = myobj.nextLine();
//        System.out.println("enter your name: ");
//        obj.userName = myobj.nextLine();
//        System.out.println("enter your zip code: ");
//        obj.zipCode = myobj.nextInt();
//        System.out.println("enter the amount payed: ");
//        obj.servicePrice = myobj.nextFloat();
//
//
//    }

}
