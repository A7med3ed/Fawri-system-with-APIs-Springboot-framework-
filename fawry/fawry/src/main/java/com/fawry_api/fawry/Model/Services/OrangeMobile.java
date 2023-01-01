package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Controller.Services.MobileRecharge;
import com.fawry_api.fawry.Model.Form;

import java.util.Scanner;

public class OrangeMobile extends MobileRecharge {

    public OrangeMobile(){
        obj =new Form();

    }
    @Override
    public String getServiceName() {
        return "Orange Mobile";
    }
}
