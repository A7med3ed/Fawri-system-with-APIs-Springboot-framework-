package com.fawry_api.fawry.Controller;

import com.fawry_api.fawry.BSL.ServiceBSL;
import com.fawry_api.fawry.Controller.Discount.Discount;
import com.fawry_api.fawry.Controller.Observers.Subject;
import com.fawry_api.fawry.Model.Operation;
import com.fawry_api.fawry.Model.Refund;
import com.fawry_api.fawry.Model.User;
import com.fawry_api.fawry.Model.Payment.Cash;
import com.fawry_api.fawry.Model.Payment.CreditCard;
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
    public
    AdminController adminControlleront;
    ServiceBSL serviceBSL;
    ServiceController() {
        serviceBSL = new ServiceBSL();
    }
    @GetMapping(value = "service/search/{question}/{choose}/{choosePay}/{price}")
    public String search(@PathVariable("question")String question,@PathVariable("choose") int choose,@PathVariable("choosePay") int choosePay,@PathVariable("price") Float price) {
       return serviceBSL.search(question,choose,choosePay,price);
    }
    @GetMapping(value = "service/requestRefund/{id}")
    public String requestRefund(@PathVariable("id") int id) {
        return serviceBSL.requestRefund(id,adminControlleront.adminBSL);
    }
    @GetMapping(value = "/service/checkDiscounts")
    public List<Discount> checkDiscounts() {
        return serviceBSL.checkDiscounts(adminControlleront);
    }
    @GetMapping(value = "service/chooseService/{chooseSer}/{Type}/{choosePay}/{price}")
    public String chooseService(@PathVariable("chooseSer")int chooseSer,@PathVariable("Type")int Type,@PathVariable("choosePay")int choosePay,@PathVariable("price") Float price) {
     return serviceBSL.chooseService(chooseSer,Type,choosePay,price,adminControlleront.adminBSL);
    }
    public String payment(double amount, int choose) {
        return serviceBSL.payment(amount,choose);
    }
    @GetMapping(value = "service/listOperation")
    public ArrayList<Operation> listOperation(){
        return serviceBSL.listOperation();
    }
    @Override
    public String notifyAmount() {
        return serviceBSL.notifyAmount();
    }
    @Override
    public String  notifyRefund() {
        return serviceBSL.notifyRefund(adminControlleront.adminBSL);
    }
}

