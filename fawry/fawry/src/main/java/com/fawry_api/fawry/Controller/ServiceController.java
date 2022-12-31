package com.fawry_api.fawry.Controller;

import com.fawry_api.fawry.Controller.Discount.Discount;
import com.fawry_api.fawry.Controller.Observers.Subject;
import com.fawry_api.fawry.Model.Operation;
import com.fawry_api.fawry.Model.Refund;
import com.fawry_api.fawry.Model.User;
import com.fawry_api.fawry.View.Payment.Cash;
import com.fawry_api.fawry.View.Payment.CreditCard;
import com.fawry_api.fawry.Controller.Services.Services;
import com.fawry_api.fawry.Controller.Payment.Payment;
import com.fawry_api.fawry.Controller.Services.Donations;
import com.fawry_api.fawry.Controller.Services.InternetPaymentServices;
import com.fawry_api.fawry.Controller.Services.Landline;
import com.fawry_api.fawry.Controller.Services.MobileRecharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Component
public class ServiceController implements Subject {
    @Autowired
    AdminController adminControlleront;

    protected ArrayList<Services> services_arr = new ArrayList<Services>();


//    protected ArrayList<User> arr = new ArrayList<User>();
    protected Payment p;
    //protected int user;
    protected static User user;
    Services service;
    ServiceController() {
    }

    @GetMapping(value = "service/search/{question}/{choose}/{choosePay}/{price}")
    public String search(@PathVariable("question")String question,@PathVariable("choose") int choose,@PathVariable("choosePay") int choosePay,@PathVariable Float price) {
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
            o =new Operation(service.getServiceprice(),user.user_name,service.getServiceName(),true);
            user.operationlist.add(o);
            return ret;
    }
    @GetMapping(value = "service/requestRefund/{id}")
    public String requestRefund(@PathVariable("id") int id) {
        for (int i = 0; i < user.operationlist.size(); i++) {
            if(user.operationlist.get(i).getId() == id){
                for (int j = 0; j < adminControlleront.refundArr.size(); j++) {
                    if (user.operationlist.get(i).getId()==adminControlleront.refundArr.get(j).opID)
                    {
                        return "Failed";
                    }
                }
                Refund r = new Refund(user.operationlist.get(i),user.getUserId());
                adminControlleront.refundArr.add(r);
                adminControlleront.refundTransactions.add(r);
                return "Successful";
                }
            }
        return "Failed";
    }

    @GetMapping(value = "/service/checkDiscounts")
    public List<Discount> checkDiscounts() {
        return adminControlleront.discountList;
    }
    @GetMapping(value = "service/chooseService/{chooseSer}/{Type}/{choosePay}/{price}")
    public String chooseService(@PathVariable("chooseSer")int chooseSer,@PathVariable("Type")int Type,@PathVariable("choosePay")int choosePay,@PathVariable Float price) {
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
                o =new Operation(service.getServiceprice(),user.user_name,service.getServiceName(),true);
                user.operationlist.add(o);
                adminControlleront.paymentTransactions.add(o);
                return ret;
    }

    public String payment(double amount, int choose) {
        String t = "";
        switch (choose) {
            case 1:
                p = user.wallet;
                t = p.pay(amount);
                notifyAmount();
                break;
            case 2:
                p = new Cash();
                t = p.pay(amount);
                break;
            case 3:
                p = new CreditCard();
                t =p.pay(amount);
                break;
        }
        return t;
    }



    @Override
    public void notifyAmount() {
        user.update(user.wallet.currentCredit + "");
    }

    @Override
    public String  notifyRefund() {
        for (int i = 0; i < adminControlleront.accepted.size(); i++) {
            if (adminControlleront.accepted.get(i).userNum == user.getUserId()) {
                String service = adminControlleront.accepted.get(i).getServiceName();
                double price= adminControlleront.accepted.get(i).getAmount();
                adminControlleront.accepted.remove(i);
                return user.update(String.format("Your Refund %s is Accepted of price %f!",service,price));
            }

        }
        for (int i = 0; i < adminControlleront.refused.size(); i++) {
            if (adminControlleront.refused.get(i).userNum == user.getUserId()) {
                String service = adminControlleront.refused.get(i).getServiceName();
                double price= adminControlleront.accepted.get(i).getAmount();
                adminControlleront.refused.remove(i);
                return user.update(String.format("Your Refund %s is Refused of price %f!",service,price));
            }

        }
        return "";
    }
    //Test function
    @GetMapping(value = "service/listOperation")
    public ArrayList<Operation> listOperation(){
        return user.operationlist;
    }
}

