package com.fawry_api.fawry.Controller.Services;

import com.fawry_api.fawry.Model.Form;
import com.fawry_api.fawry.Model.User;

public  abstract class Services {
    public static double OverallDiscount = 0.0;
     public Form obj ;
    public abstract void setDiscountValue(double d);

    public abstract String getServiceName();

    public void getinfo(Float price){
        obj.servicePrice = price;
    };
    public abstract Services get_service(int Type);
    public void applyDis(User user){
        if(user.operationlist.isEmpty()){
            obj.servicePrice = obj.servicePrice - obj.servicePrice*OverallDiscount;
        }
    }
    public abstract double getServiceprice();
}
