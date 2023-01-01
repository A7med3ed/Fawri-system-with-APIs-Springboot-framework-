package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Controller.Services.MobileRecharge;
import com.fawry_api.fawry.Model.Form;

import java.util.Scanner;

public class VodafoneMobile extends MobileRecharge {
    public VodafoneMobile(){
        obj =new Form();
    }
    @Override
    public String getServiceName() {
        return "Vodafone Mobile";
    }




}
