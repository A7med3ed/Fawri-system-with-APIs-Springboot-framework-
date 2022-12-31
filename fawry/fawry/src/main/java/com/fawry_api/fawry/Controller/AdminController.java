package com.fawry_api.fawry.Controller;
import com.fawry_api.fawry.Controller.Discount.Discount;
import com.fawry_api.fawry.Controller.Payment.Funds;
import com.fawry_api.fawry.Controller.Services.Services;
import com.fawry_api.fawry.Model.Operation;
import com.fawry_api.fawry.Model.Refund;
import com.fawry_api.fawry.Controller.Services.Donations;
import com.fawry_api.fawry.Controller.Services.InternetPaymentServices;
import com.fawry_api.fawry.Controller.Services.Landline;
import com.fawry_api.fawry.Controller.Services.MobileRecharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
@RestController
public class AdminController {
    @Autowired
            DiscountController discountController;


    public ArrayList<Refund> refundArr = new ArrayList<Refund>();
    protected ArrayList<Refund> accepted=new ArrayList<Refund>();
    protected ArrayList<Refund> refused=new ArrayList<>();
    protected List<Discount> discountList = new ArrayList<>();
    protected List<Operation> paymentTransactions = new ArrayList<>();
    protected List<Funds> addToWalletTransactions = new ArrayList<>();
    protected List<Refund> refundTransactions = new ArrayList<>();
    protected Services services;
    AdminController(){}

    @GetMapping(value = "/Admin/ListRefund")
    public ArrayList<Refund> listRefund() {
        return refundArr;
    }




    @PostMapping(value = "/Admin/ChooseRefund/{i}/{choice}")
    public String chooseRefund(@PathVariable("i") int i,@PathVariable("choice") int choice) {
            switch (choice) {
                case 1:
                    accepted.add(refundArr.get(i));//2,3,2,1
                    refundArr.remove(i);
                    return "Accepted";
                case 2:
                    refused.add(refundArr.get(i));
                    refundArr.remove(i);
                    return "Refused";
                case 3:
                    Refund temp = refundArr.get(i);
                    refundArr.remove(i);
                    refundArr.add(temp);
                    return "Ignored";
                default:
                    System.exit(0);
            }

            return "";
        }


    @GetMapping(value = "/Admin/addDiscount/{choice}/{chooseSer}/{precentage}")
    public void addDiscount(@PathVariable("choice") int choice,@PathVariable("chooseSer")String chooseSer,@PathVariable("precentage") double precentage) {
        switch (choice) {
            case 1:
                precentage =precentage/100;
                discountList.add(discountController.setDiscount(precentage));
                break;
            case 2:
                   if(Objects.equals(chooseSer, new MobileRecharge().getServiceName())){
                        services = new MobileRecharge();
                    } else if (Objects.equals(chooseSer, new InternetPaymentServices().getServiceName())) {
                        services = new InternetPaymentServices();
                   } else if (Objects.equals(chooseSer, new Landline().getServiceName())) {
                        services = new Landline();
                   } else if (Objects.equals(chooseSer, new Donations().getServiceName())) {
                        services = new Donations();
                   }
                        precentage = precentage / 100;
                        discountList.add(discountController.setDiscount(chooseSer,precentage));
                break;

        }

    }



}
