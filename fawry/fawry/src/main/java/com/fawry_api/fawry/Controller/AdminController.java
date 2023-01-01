package com.fawry_api.fawry.Controller;
import com.fawry_api.fawry.BSL.AdminBSL;
import com.fawry_api.fawry.Controller.Payment.Funds;
import com.fawry_api.fawry.Model.Operation;
import com.fawry_api.fawry.Model.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
public class AdminController {
    @Autowired
      public   DiscountController discountController;
    public AdminBSL adminBSL;
    AdminController(){
        adminBSL = new AdminBSL();
    }
    @GetMapping(value = "/Admin/ListRefund")
    public ArrayList<Refund> listRefund() {
        return adminBSL.listRefund();
    }
    @GetMapping(value = "/admin/listPayment")
    public List<Operation> getPaymentTransactions() {
        return adminBSL.getPaymentTransactions();
    }
    @GetMapping(value = "/admin/listAddToWallet")
    public List<Funds> getAddToWalletTransactions() {
        return adminBSL.getAddToWalletTransactions();
    }
    @GetMapping(value = "/admin/listRefunds")
    public List<Refund> getRefundTransactions() {
        return adminBSL.getRefundTransactions();
    }
    @PostMapping(value = "/Admin/ChooseRefund/{i}/{choice}")
    public String chooseRefund(@PathVariable("i") int i,@PathVariable("choice") int choice) {
            return adminBSL.chooseRefund(i,choice);
        }
    @GetMapping(value = "/Admin/addDiscount/{choice}/{chooseSer}/{precentage}")
    public String addDiscount(@PathVariable("choice") int choice,@PathVariable("chooseSer")String chooseSer,@PathVariable("precentage") double precentage) {
        return adminBSL.addDiscount(choice,chooseSer,precentage,discountController);
    }
}
