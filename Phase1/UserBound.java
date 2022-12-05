import java.util.Arrays;
import java.util.Scanner;

public class UserBound  {
    Scanner myObj = new Scanner(System.in);
    ServiceController cont = ServiceController.getInstance();

    void notification(){
        cont.notifyRefund();


    }



    boolean sign_in(){
        String ent_email,ent_pass;
        System.out.println("Enter your Email:");
        ent_email=myObj.next();
        System.out.println("Enter your password:");
        ent_pass=myObj.next();
        return cont.find(ent_email,ent_pass);




    }


    boolean sign_up(){
        String ent_email,ent_pass,ent_username;
        System.out.println("Enter your Email:");
        ent_email=myObj.next();
        System.out.println("Enter your User Name:");
        ent_username=myObj.next();
        System.out.println("Enter your password:");
        ent_pass=myObj.next();
        return cont.find(ent_username,ent_email,ent_pass);

    }

    public void ChooseServices() {
        while (true) {
            System.out.println("Choose Needed service");
            System.out.println("1- Search");
            System.out.println("2- check discounts");
            System.out.println("3- add funds to wallet");
            System.out.println("4- request refund");
            System.out.println("5- choose needed service");

            int choose;
            choose = myObj.nextInt();
            switch (choose) {
                case 1:
                    cont.search();
                    break;
                case 2:
                    cont.checkDiscount();
                    break;
                case 3:
                    cont.addFundsWallet();
                    break;
                case 4:
                    cont.requestRefund();
                    break;
                case 5:
                    cont.chooseService();
                    break;
                default:
                    System.exit(0);
            }
                    System.out.println("would you like to make another service?");
                    System.out.println("Choose: ");
                    System.out.println("1-Yes");
                    System.out.println("2-No");
                    int ans = myObj.nextInt();
                    if (ans == 2) {
                        break;
                    }

        }
    }



}