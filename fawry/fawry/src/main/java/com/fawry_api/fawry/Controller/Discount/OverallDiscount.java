package com.fawry_api.fawry.Controller.Discount;

import com.fawry_api.fawry.Controller.Services.Services;

public class OverallDiscount extends Discount {

    public OverallDiscount(String service, Double serviceDiscount) {
        super(service, serviceDiscount);
    }

    @Override
    public void setDiscount(String service, double serviceDiscount) {
        Services.OverallDiscount =serviceDiscount;
    }
}
