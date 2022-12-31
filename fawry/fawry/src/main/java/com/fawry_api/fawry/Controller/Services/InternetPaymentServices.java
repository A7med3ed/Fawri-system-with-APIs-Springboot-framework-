package com.fawry_api.fawry.Controller.Services;

import com.fawry_api.fawry.Controller.Factory.Service_Factory;
import com.fawry_api.fawry.Controller.Factory.Service_creator;

public class InternetPaymentServices extends Services {

   public static double discountValue = 0.0;
//    public void getinfo() {}

    public InternetPaymentServices get_service(int Type){
        Service_Factory Ser=new Service_creator();
        return Ser.Creator_I(Type);
    }

    @Override
    public void setDiscountValue(double d) {
        discountValue = d;
    }

    public String getServiceName(){
        return "Internet payment";
    }
    @Override
    public double getServiceprice(){

        return obj.servicePrice - obj.servicePrice*discountValue;
    }



}
