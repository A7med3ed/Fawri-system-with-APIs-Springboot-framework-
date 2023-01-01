package com.fawry_api.fawry.BSL;

import com.fawry_api.fawry.Controller.Discount.Discount;
import com.fawry_api.fawry.Controller.DiscountController;
import com.fawry_api.fawry.Controller.Payment.Funds;
import com.fawry_api.fawry.Controller.ServiceController;
import com.fawry_api.fawry.Controller.Services.*;
import com.fawry_api.fawry.Model.Operation;
import com.fawry_api.fawry.Model.Refund;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Service
public class AdminBSL {

    public ArrayList<Refund> refundArr = new ArrayList<Refund>();
    public ArrayList<Refund> accepted = new ArrayList<Refund>();
    public ArrayList<Refund> refused = new ArrayList<>();
    public List<Discount> discountList = new ArrayList<>();
    public List<Operation> paymentTransactions = new ArrayList<>();


    public List<Funds> addToWalletTransactions = new ArrayList<>();
    public List<Refund> refundTransactions = new ArrayList<>();
    protected Services services;
    public List<Operation> getPaymentTransactions() {
        return paymentTransactions;
    }

    public List<Funds> getAddToWalletTransactions() {
        return addToWalletTransactions;
    }

    public List<Refund> getRefundTransactions() {
        return refundTransactions;
    }

    public ArrayList<Refund> listRefund() {
        return refundArr;
    }


    public String chooseRefund(int i, int choice) {
        Refund choosenRefund = findRefund(i);
        if(choosenRefund != null){
            switch (choice) {
                case 1:
                    accepted.add(choosenRefund);
                    refundArr.remove(choosenRefund);
                    removeAcceptedRefunds();
                    return "Accepted";
                case 2:
                    refused.add(choosenRefund);
                    refundArr.remove(choosenRefund);
                    return "Refused";
                case 3:
                    Refund temp = choosenRefund;
                    refundArr.remove(choosenRefund);
                    refundArr.add(temp);
                    return "Ignored";
                default:
                    System.exit(0);
            }
        }
        return "Wrong refund id";
    }


    public String addDiscount(int choice, String chooseSer, double precentage,DiscountController discountController) {
        switch (choice) {
            case 1:
                precentage = precentage / 100;
                discountList.add(discountController.setDiscount(precentage));
                return "Successful";
            case 2:
                if (Objects.equals(chooseSer, new MobileRecharge().getServiceName())) {
                    services = new MobileRecharge();
                } else if (Objects.equals(chooseSer, new InternetPaymentServices().getServiceName())) {
                    services = new InternetPaymentServices();
                } else if (Objects.equals(chooseSer, new Landline().getServiceName())) {
                    services = new Landline();
                } else if (Objects.equals(chooseSer, new Donations().getServiceName())) {
                    services = new Donations();
                }
                precentage = precentage / 100;
                discountList.add(discountController.setDiscount(chooseSer, precentage));
                return "Successful";
        }
        return "Failed";
    }
    public Refund findRefund(int id){
        for (Refund r:refundArr) {
            if(r.getId() ==  id){
                return r;
            }
        }
        return null;
    }
    public void removeAcceptedRefunds(){

        for (int i = 0; i <accepted.size() ; i++) {
            if(Objects.equals(ServiceBSL.user.user_name, accepted.get(i).getUserName())){
                for (int j = 0; j < ServiceBSL.user.operationlist.size(); j++) {
                    if(Objects.equals(ServiceBSL.user.operationlist.get(j).getId(),accepted.get(i).opID)){
                        ServiceBSL.user.operationlist.remove(i);
                    }
                }
            }
        }

    }
}