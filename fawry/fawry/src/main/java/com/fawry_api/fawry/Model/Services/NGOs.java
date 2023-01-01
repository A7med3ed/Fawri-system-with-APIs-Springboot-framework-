package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Controller.Services.Donations;
import com.fawry_api.fawry.Model.Form;

import java.util.Scanner;

public class NGOs extends Donations {

    public NGOs(){
        obj =new Form();

    }
    @Override
    public String getServiceName() {
        return "NGOs";
    }



}
