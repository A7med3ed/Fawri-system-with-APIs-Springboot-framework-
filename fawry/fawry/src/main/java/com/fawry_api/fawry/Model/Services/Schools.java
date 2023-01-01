package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Model.Form;
import com.fawry_api.fawry.Controller.Services.Donations;

import java.util.Scanner;

public class Schools extends Donations {

    public Schools(){
        obj =new Form();

    }
    @Override
    public String getServiceName() {
        return "Schools";
    }


}
