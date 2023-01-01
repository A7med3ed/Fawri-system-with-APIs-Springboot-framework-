package com.fawry_api.fawry.Controller;

import com.fawry_api.fawry.Controller.Discount.Discount;
import com.fawry_api.fawry.Controller.Discount.OverallDiscount;
import com.fawry_api.fawry.Controller.Discount.SpecificDiscount;
import com.fawry_api.fawry.Controller.Services.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Component
public class DiscountController {
    Discount discount;
    public Discount setDiscount(String name,double discountValue){
        discount = new SpecificDiscount(name,discountValue);
        discount.setDiscount(name,discountValue);
        return discount;
    }
        public Discount setDiscount(double discountValue){
            discount = new OverallDiscount("Overall",discountValue);
            discount.setDiscount("Overall",discountValue);
            return discount;
        }
}


