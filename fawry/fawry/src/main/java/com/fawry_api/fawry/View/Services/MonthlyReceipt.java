package com.fawry_api.fawry.View.Services;

import com.fawry_api.fawry.Model.Form;
import com.fawry_api.fawry.Controller.Services.Landline;

import java.util.Scanner;

public class MonthlyReceipt extends Landline {
    Scanner myobj =new Scanner(System.in);

    public MonthlyReceipt(){
        obj =new Form();

    }

    @Override
    public String getServiceName() {
        return "Monthly Internet";
    }
//    public void getinfo(){
//        System.out.println("enter your phone number: ");
//        obj.phoneNumber = myobj.nextLine();
//        System.out.println("enter your name: ");
//        obj.userName = myobj.nextLine();
//        System.out.println("enter nearest branch from your home: ");
//        obj.nearest_branch = myobj.nextLine();
//        System.out.println("enter the amount payed: ");
//        obj.servicePrice = myobj.nextFloat();
//        System.out.println("enter your zip code: ");
//        obj.zipCode = myobj.nextInt();
//
//    }
}
