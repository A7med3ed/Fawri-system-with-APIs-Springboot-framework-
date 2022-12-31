package com.fawry_api.fawry.Controller.Discount;
public abstract class Discount{
    private String service;
    private Double serviceDiscount;

    public Discount(String service, Double serviceDiscount) {
        this.service = service;
        this.serviceDiscount = serviceDiscount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Double getServiceDiscount() {
        return serviceDiscount;
    }

    public void setServiceDiscount(Double serviceDiscount) {
        this.serviceDiscount = serviceDiscount;
    }
    public abstract void setDiscount(String service,double serviceDiscount);



}
