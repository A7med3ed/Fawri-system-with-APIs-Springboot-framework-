package com.fawry_api.fawry.Model;

public class Refund extends Operation {
    static int idRefund = 0;
    public int opID;
    public Refund(Operation o, int userNum) {
        super(o.amount, o.userName, o.serviceName,false);
        id = idRefund++;
        opID = o.id;
        this.userNum = userNum;
    }
    public int userNum;
    public String getServiceName() {
        return serviceName;
    }
}

