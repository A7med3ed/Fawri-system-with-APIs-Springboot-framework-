package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Model.Form;
import com.fawry_api.fawry.Controller.Services.Landline;

import java.util.Scanner;

public class QuarterReceipt extends Landline {

    public QuarterReceipt(){
        obj =new Form();
        obj.servicePrice = 123.0;

    }
    @Override
    public String getServiceName() {
        return "Quarter Internet";
    }

}
