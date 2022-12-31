package com.fawry_api.fawry.Controller.Discount;

import com.fawry_api.fawry.Controller.Services.*;

import java.util.Objects;

public class SpecificDiscount extends Discount {
    Services services;

    public SpecificDiscount(String service, Double serviceDiscount) {
        super(service, serviceDiscount);
    }

    @Override
    public void setDiscount(String service, double serviceDiscount) {
        if(Objects.equals(service, new MobileRecharge().getServiceName())){
            services = new MobileRecharge();
            services.setDiscountValue(serviceDiscount);
        } else if (Objects.equals(service, new InternetPaymentServices().getServiceName())) {
            services = new InternetPaymentServices();
            services.setDiscountValue(serviceDiscount);
        } else if (Objects.equals(service, new Landline().getServiceName())) {
            services = new Landline();
            services.setDiscountValue(serviceDiscount);
        } else if (Objects.equals(service, new Donations().getServiceName())) {
            services = new Donations();
            services.setDiscountValue(serviceDiscount);
        }
    }
}

