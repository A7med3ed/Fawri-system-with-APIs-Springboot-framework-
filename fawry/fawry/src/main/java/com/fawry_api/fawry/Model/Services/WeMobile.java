package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Controller.Services.MobileRecharge;
import com.fawry_api.fawry.Model.Form;

import java.util.Scanner;

public class WeMobile extends MobileRecharge {

    public WeMobile(){
        obj =new Form();

    }
    @Override
    public String getServiceName() {
        return "We Mobile";
    }

}
