import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {
    Scanner myObj = new Scanner(System.in);

    protected ArrayList<Refund> refundArr = new ArrayList<Refund>();
    protected ArrayList<Integer> accepted=new ArrayList<Integer>();
    protected ArrayList<Integer> refused=new ArrayList<Integer>();
    protected ArrayList<Integer> Dis_arr = new ArrayList<Integer>();


    protected Discounts D;
    protected Service services;
    private static AdminController ac;
    AdminController(){
        for(int i=0;i<5;i++){
            Dis_arr.add(0);
        }

    }
    public static AdminController getInstance(){
        if(ac==null)
            ac=new AdminController();
        return ac;
    }


    public void listRefunds() {
        for (int i = 0; i < refundArr.size(); i++) {
            System.out.println(refundArr.get(i).getServiceName());
            System.out.println(refundArr.get(i).getServicePrice());
            System.out.println(refundArr.get(i).getServiceCode());
            System.out.println("1-Accept");
            System.out.println("2-Refuse");
            System.out.println("3-Ignore");
            int choice = myObj.nextInt();
            switch (choice) {
                case 1:
                    refundArr.get(i).setServiceStatus("Accepted");
                    accepted.add(refundArr.get(i).userNum);
                    refundArr.remove(i);
                    break;
                case 2:
                    refundArr.get(i).setServiceStatus("Refused");
                    refused.add(refundArr.get(i).userNum);
                    refundArr.remove(i);
                    break;
                case 3:
                    refundArr.get(i).setServiceStatus("Ignored");
                    Refund temp = refundArr.get(i);
                    refundArr.remove(i);
                    refundArr.add(temp);

                    break;
            }
        }
    }

    public void addDiscount() {
        int choice;
        System.out.println("Choose one of discounts");
        System.out.println("1- Overall discount: ");
        System.out.println("2- specific discount");
        choice = myObj.nextInt();
        switch (choice) {
            case 1:
                D=new OverallDiscount();
                int precentage;

                //  D.applyDiscount();
                System.out.println("Enter discount: ");
                precentage = myObj.nextInt();
                Dis_arr.set(4,precentage);
                break;
            case 2:

                D=new SpecificDiscount();
                //D.applyDiscount();
                int chooseSer;

                System.out.println("Choose one of Services:");
                System.out.println("1- Mobile recharge services");
                System.out.println("2- Internet Payment services");
                System.out.println("3- Landline services");
                System.out.println("4- Donations services");
                chooseSer = myObj.nextInt();
                switch (chooseSer) {
                    case 1:
                        services = new MobileRecharge();
                        System.out.println("Enter discount: ");
                        precentage = myObj.nextInt();
                        Dis_arr.set(chooseSer-1,precentage);
                        break;
                    case 2:
                        services = new InternetPaymentService();
                        System.out.println("Enter discount: ");
                        precentage = myObj.nextInt();
                        Dis_arr.set(chooseSer-1,precentage);
                        break;
                    case 3:
                        services = new Landline();
                        System.out.println("Enter discount: ");
                        precentage = myObj.nextInt();
                        Dis_arr.set(chooseSer-1,precentage);
                        break;
                    case 4:
                        services = new Donations();
                        System.out.println("Enter discount: ");
                        precentage = myObj.nextInt();
                        Dis_arr.set(chooseSer-1,precentage);
                        break;

                }
                break;

        }

}



}