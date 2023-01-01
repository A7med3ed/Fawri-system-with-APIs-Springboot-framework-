package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Model.Form;
import com.fawry_api.fawry.Controller.Services.Landline;

import java.util.Scanner;

public class MonthlyReceipt extends Landline {

    public MonthlyReceipt(){
        obj =new Form();

    }

    @Override
    public String getServiceName() {
        return "Monthly Internet";
    }

}
