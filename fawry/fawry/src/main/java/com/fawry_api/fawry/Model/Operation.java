package com.fawry_api.fawry.Model;

public class Operation {
    String userName;
    static int idCount = 0;
    int id;
    double amount;
    String serviceName;
    public Operation(double amount,String userName,String serviceName,boolean flag){
        this.amount = amount;
        this.userName = userName;
        this.serviceName = serviceName;
        id = idCount;
        if(flag)
            idCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}