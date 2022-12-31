package com.fawry_api.fawry.View.Services;

import com.fawry_api.fawry.Controller.Services.Donations;
import com.fawry_api.fawry.Model.Form;

import java.util.Scanner;

public class CancerHospital extends Donations {
    Scanner myobj =new Scanner(System.in);

    public CancerHospital(){
        obj =new Form();

    }
    @Override
    public String getServiceName() {
        return "Cancer Hospital";
    }
//    @Override
//    public void getinfo(){
//        System.out.println("enter your phone number: ");
//        obj.phoneNumber = myobj.nextLine();
//        System.out.println("enter your name: ");
//        obj.userName = myobj.nextLine();
//        System.out.println("enter the amount payed: ");
//        obj.servicePrice = myobj.nextFloat();
//    }
}
