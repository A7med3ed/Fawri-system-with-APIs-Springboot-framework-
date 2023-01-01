package com.fawry_api.fawry.BSL;

import com.fawry_api.fawry.Controller.AdminController;
import com.fawry_api.fawry.Controller.Discount.Discount;
import com.fawry_api.fawry.Controller.Payment.Payment;
import com.fawry_api.fawry.Controller.Services.*;
import com.fawry_api.fawry.Model.Operation;
import com.fawry_api.fawry.Model.Payment.Cash;
import com.fawry_api.fawry.Model.Payment.CreditCard;
import com.fawry_api.fawry.Model.Refund;
import com.fawry_api.fawry.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceBSL {
    protected Payment p;
    public static User user;
    Services service;
    public String search(String question, int choose, int choosePay,  Float price) {
        String ret;
        Operation o;
        if (question.equals("Vodafone")) {
            switch (choose) {
                case 1:
                    service = new MobileRecharge().get_service(1);
                    break;
                case 2:
                    service = new InternetPaymentServices().get_service(1);
                    break;
            }
        } else if (question.equals("Etisalat")) {
            switch (choose) {
                case 1:
                    service = new MobileRecharge().get_service(3);
                    break;
                case 2:
                    service = new InternetPaymentServices().get_service(3);
                    break;
            }
        } else if (question.equals("We")) {
            switch (choose) {
                case 1:
                    service = new MobileRecharge().get_service(2);
                    break;

                case 2:
                    service = new InternetPaymentServices().get_service(2);

                    break;
            }
        } else if (question.equals("Orange")) {
            switch (choose) {
                case 1:
                    service = new MobileRecharge().get_service(4);

                    break;

                case 2:
                    service = new InternetPaymentServices().get_service(4);
                    break;
            }
        } else if (question.equals("Donations")) {

            service = new Donations().get_service(choose);
        } else if (question.equals("landline")) {

            service = new Landline().get_service(choose);
        }else {
            return "Service not found";
        }
        service.getinfo(price);
        service.applyDis(user);
        ret = payment(service.getServiceprice(),choosePay);
        if (Objects.equals(ret, "Failed"))
            return ret;
        o =new Operation(service.getServiceprice(),user.user_name,service.getServiceName(),true);
        user.operationlist.add(o);
        return ret;
    }
    public String requestRefund( int id,AdminBSL adminbsl) {
        for (int i = 0; i < user.operationlist.size(); i++) {
            if(user.operationlist.get(i).getId() == id){
                for (int j = 0; j < adminbsl.refundArr.size(); j++) {
                    if (user.operationlist.get(i).getId()== adminbsl.refundArr.get(j).opID)
                    {
                        return "Failed";
                    }
                }
                Refund r = new Refund(user.operationlist.get(i),user.getUserId());
                adminbsl.refundArr.add(r);
                adminbsl.refundTransactions.add(r);
                return "Successful";
            }
        }
        return "Failed";
    }

    public List<Discount> checkDiscounts(AdminController adminController) {
        return adminController.adminBSL.discountList;
    }
    public String chooseService(int chooseSer,int Type,int choosePay, Float price,AdminBSL adminbsl) {
        String ret;
        Operation o;
        switch (chooseSer) {
            case 1:
                service = new MobileRecharge().get_service(Type);
                break;
            case 2:
                service = new InternetPaymentServices().get_service(Type);
                break;

            case 3:
                service = new Landline().get_service(Type);
                break;
            case 4:
                service = new Donations().get_service(Type);
                break;
            default:
                System.exit(0);
        }
        service.getinfo(price);
        service.applyDis(user);
        ret = payment(service.getServiceprice(),choosePay);
        if (Objects.equals(ret, "Failed"))
            return ret;
        o =new Operation(service.getServiceprice(),user.user_name,service.getServiceName(),true);
        user.operationlist.add(o);
        adminbsl.paymentTransactions.add(o);
        return ret;
    }

    public String payment(double amount, int choose) {
        String t = "";
        switch (choose) {
            case 1:
                p = user.wallet;
                t = p.pay(amount);
                notifyAmount();
                return t+"\n"+notifyAmount();
            case 2:
                p = new Cash();
                t = p.pay(amount);
                return t;
            case 3:
                p = new CreditCard();
                t =p.pay(amount);
                return t;
        }
        return t;
    }

    public String notifyAmount() {
        return user.update("Remaining in the wallet: "+user.wallet.currentCredit + "");
    }


    public String  notifyRefund(AdminBSL adminbsl) {
        for (int i = 0; i < adminbsl.accepted.size(); i++) {
            if (adminbsl.accepted.get(i).userNum == user.getUserId()) {
                String service = adminbsl.accepted.get(i).getServiceName();
                double price= adminbsl.accepted.get(i).getAmount();
                adminbsl.accepted.remove(i);
                return user.update(String.format("Your Refund %s is Accepted of price %f!",service,price));
            }

        }
        for (int i = 0; i < adminbsl.refused.size(); i++) {
            if (adminbsl.refused.get(i).userNum == user.getUserId()) {
                String service = adminbsl.refused.get(i).getServiceName();
                double price= adminbsl.accepted.get(i).getAmount();
                adminbsl.refused.remove(i);
                return user.update(String.format("Your Refund %s is Refused of price %f!",service,price));
            }

        }
        return "";
    }
    public ArrayList<Operation> listOperation(){
        return user.operationlist;
    }
}
