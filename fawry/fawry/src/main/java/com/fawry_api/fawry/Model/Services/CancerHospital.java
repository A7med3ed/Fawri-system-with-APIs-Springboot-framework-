package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Controller.Services.Donations;
import com.fawry_api.fawry.Model.Form;

import java.util.Scanner;

public class CancerHospital extends Donations {

    public CancerHospital(){
        obj =new Form();

    }
    @Override
    public String getServiceName() {
        return "Cancer Hospital";
    }
}
