package com.fawry_api.fawry.Model.Services;

import com.fawry_api.fawry.Controller.Services.InternetPaymentServices;
import com.fawry_api.fawry.Model.Form;

import java.util.Scanner;

public class EtisalatInternet extends InternetPaymentServices {

    @Override
    public String getServiceName() {
        return "Etisalat Internet";
    }

}
