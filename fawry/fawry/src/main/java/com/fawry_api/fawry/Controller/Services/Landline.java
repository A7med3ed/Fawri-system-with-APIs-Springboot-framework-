package com.fawry_api.fawry.Controller.Services;

import com.fawry_api.fawry.Controller.Factory.Service_Factory;
import com.fawry_api.fawry.Controller.Factory.Service_creator;

public class Landline extends Services {
    int phoneNum;
    public static double discountValue = 0.0;

    @Override
    public void setDiscountValue(double d) {
        discountValue = d;
    }

    @Override
    public String getServiceName() {
        return "Landline";
    }

//    public void getinfo() {}

    public Landline get_service(int receiptType){
        Service_Factory Ser=new Service_creator();
        return Ser.Creator_L(receiptType);


    }
    @Override
    public double getServiceprice(){
        return obj.servicePrice - obj.servicePrice*discountValue;
    }


}
