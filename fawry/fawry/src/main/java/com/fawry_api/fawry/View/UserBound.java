package com.fawry_api.fawry.View;

import com.fawry_api.fawry.Controller.ServiceController;
import com.fawry_api.fawry.Controller.UserController;
import com.fawry_api.fawry.Model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Scanner;

public class UserBound  {
    Scanner myObj = new Scanner(System.in);
//    ServiceController serviceController = ServiceController.getInstance();
//    UserController userController = UserController.getInstance();
//    public void notification(){
//        serviceController.notifyRefund();
//    }



//    public String sign_in( User u){
//        String ent_email,ent_pass;
//        System.out.println("Enter your Email:");
//        ent_email=u.email;
//        System.out.println("Enter your password:");
//        ent_pass=u.password;
//        return userController.find(ent_email,ent_pass);
//    }


//    public String sign_up(User u){
//        String ent_email,ent_pass,ent_username;
//        System.out.println("Enter your Email:");
//        ent_email=u.email;
//        System.out.println("Enter your User Name:");
//        ent_username=u.user_name;
//        System.out.println("Enter your password:");
//        ent_pass=u.password;
//        return userController.find(u.user_name,u.email,u.password);
//    }
//
//    public void ChooseServices() {
//        while (true) {
//            System.out.println("Choose Needed service");
//            System.out.println("1- Search");
//            System.out.println("2- Check discounts");
//            System.out.println("3- Add funds to wallet");
//            System.out.println("4- Request refund");
//            System.out.println("5- Choose needed service");
//            System.out.println("6- Exit");
//
//            int choose;
//            choose = myObj.nextInt();
//            switch (choose) {
//                case 1:
//                    System.out.println("Enter your query:");
//
//                    String question;
//
//                    int chooseSearch = 0;
//
//                    question = myObj.next();
//                    if (question.equals("Vodafone")) {
//                        System.out.println("Choose one of Services:");
//                        System.out.println("1- Mobile recharge services");
//                        System.out.println("2- Internet Payment services");
//                        chooseSearch = myObj.nextInt();
//
//                    } else if (question.equals("Etisalat")) {
//                        System.out.println("Choose one of Services:");
//                        System.out.println("1- Mobile recharge services");
//                        System.out.println("2- Internet Payment services");
//                        chooseSearch = myObj.nextInt();
//
//                    } else if (question.equals("We")) {
//                        System.out.println("Choose one of Services:");
//                        System.out.println("1- Mobile recharge services");
//                        System.out.println("2- Internet Payment services");
//                        chooseSearch = myObj.nextInt();
//
//                    } else if (question.equals("Orange")) {
//                        System.out.println("Choose one of Services:");
//                        System.out.println("1- Mobile recharge services");
//                        System.out.println("2- Internet Payment services");
//                        chooseSearch = myObj.nextInt();
//
//                    } else if (question.equals("Discounts")) {
//                        System.out.println("1- Cancer Hospital");
//                        System.out.println("2- Schools");
//                        System.out.println("3- NGOs");
//                        System.out.println("Enter number of organization:");
//                        chooseSearch = myObj.nextInt();
//
//
//                    } else if (question.equals("landline")) {
//                        System.out.println("1- Monthly receipt");
//                        System.out.println("2- Quarter receipt");
//                        System.out.println("Enter period needed:");
//                        chooseSearch = myObj.nextInt();
//
//
//                    }
//                    int choosePay;
//                    System.out.println("Choose Payment method:");
//                    System.out.println("1- Wallet");
//                    System.out.println("2- Cash");
//                    System.out.println("3- Credit Card");
//                    choosePay = myObj.nextInt();
//                    serviceController.search(question,chooseSearch,choosePay);
//                    break;
//                case 2:
//                    serviceController.checkDiscount();
//                    break;
//                case 3:
//                    System.out.println("Enter the amount");
//                    Float amount = myObj.nextFloat();
//                    userController.addFundsWallet(amount);
//                    break;
//                case 4:
//                    String code, name, price;
//                    System.out.println("Enter Name of service:");
//                    name = myObj.next();
//                    System.out.println("Enter code number of operation:");
//                    code = myObj.next();
//                    System.out.println("Enter price of service:");
//                    price = myObj.next();
//                    serviceController.requestRefund(name,price,code);
//                    break;
//                case 5:
//                    int chooseSer;
//                    int Type = 0;
//                    System.out.println("Choose one of Services:");
//                    System.out.println("1- Mobile recharge services");
//                    System.out.println("2- Internet Payment services");
//                    System.out.println("3- Landline services");
//                    System.out.println("4- Donations services");
//                    chooseSer = myObj.nextInt();
//                    switch (chooseSer){
//                        case 1:
//                            System.out.println("1- Vodafone mobile services");
//                            System.out.println("2- We mobile services");
//                            System.out.println("3- Etisalat mobile services");
//                            System.out.println("4- Orange mobile services");
//                            System.out.println("Enter name of company:");
//                            Type = myObj.nextInt();
//                            break;
//                        case 2:
//                            System.out.println("1- Vodafone internet services");
//                            System.out.println("2- We internet services");
//                            System.out.println("3- Etisalat internet services");
//                            System.out.println("4- Orange internet services");
//                            System.out.println("Enter name of company:");
//                            Type = myObj.nextInt();
//                            break;
//                        case 3:
//                            System.out.println("1- Monthly receipt");
//                            System.out.println("2- Quarter receipt");
//                            System.out.println("Enter period needed:");
//                            Type = myObj.nextInt();
//                            break;
//                        case 4:
//                            System.out.println("1- Cancer Hospital");
//                            System.out.println("2- Schools");
//                            System.out.println("3- NGOs");
//                            System.out.println("Enter name of organization:");
//                            Type = myObj.nextInt();
//                            break;
//                        default:
//                            System.exit(0);
//
//                    }
//                    System.out.println("Choose Payment method:");
//                    System.out.println("1- Wallet");
//                    System.out.println("2- Cash");
//                    System.out.println("3- Credit Card");
//                    choosePay = myObj.nextInt();
//                    serviceController.chooseService(chooseSer,Type,choosePay);
//                    break;
//                case 6:
//                    break;
//                default:
//                    System.exit(0);
//            }
//            System.out.println("would you like to make another service?");
//            System.out.println("Choose: ");
//            System.out.println("1-Yes");
//            System.out.println("2-No");
//            int ans = myObj.nextInt();
//            if (ans == 2) {
//                break;
//            }
//
//        }
//    }
//
//

}
