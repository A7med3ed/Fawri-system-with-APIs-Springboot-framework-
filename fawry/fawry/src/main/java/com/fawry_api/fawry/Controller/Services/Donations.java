package com.fawry_api.fawry.Controller.Services;

import com.fawry_api.fawry.Controller.Factory.Service_Factory;
import com.fawry_api.fawry.Controller.Factory.Service_creator;

public class Donations extends Services {

    public static double discountValue = 0.0;

    @Override
    public void setDiscountValue(double d) {
        discountValue = d;
    }
    @Override
    public String getServiceName() {
        return "Donations";
    }
    public  Donations get_service(int donationType){
       Service_Factory Ser=new Service_creator();
        return Ser.Creator_D(donationType);


   }
    @Override
    public double getServiceprice(){

        return obj.servicePrice - obj.servicePrice*discountValue;
    }




}
