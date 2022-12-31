package com.fawry_api.fawry.Controller.Services;

import com.fawry_api.fawry.Controller.Factory.Service_Factory;
import com.fawry_api.fawry.Controller.Factory.Service_creator;

public class MobileRecharge extends Services {
    public static double discountValue = 0.0;

    @Override
    public void setDiscountValue(double d) {
        discountValue = d;
    }
    @Override
    public String getServiceName() {
        return "Mobile recharge";
    }

//    @Override
//    public void getinfo() {}

    public MobileRecharge get_service(int Type){
      Service_Factory Ser=new Service_creator();
        return Ser.Creator_M(Type);
   }
    public double getServiceprice(){
        return obj.servicePrice - obj.servicePrice*discountValue;
    }





}
