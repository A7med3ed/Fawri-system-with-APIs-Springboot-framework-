import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ServiceController implements  Subject {
    Scanner myObj = new Scanner(System.in);

    protected ArrayList<Service> services_arr = new ArrayList<Service>();


    protected ArrayList<User> arr = new ArrayList<User>();
    protected Payment p;
    protected int user;
    Service service;
    AdminController adminControlleront = AdminController.getInstance();
    private static ServiceController sc;
    Discounts d1 = new OverallDiscount();
    Discounts d2 = new SpecificDiscount();

    ServiceController() {
    }

    public static ServiceController getInstance() {
        if (sc == null)
            sc = new ServiceController();
        return sc;
    }

    public boolean find(String email, String password) {
        for (int x = 0; x < arr.size(); x++) {
            if (Objects.equals(arr.get(x).password, password) && Objects.equals(arr.get(x).email, email)) {
                user = x;
                return true;
            } else
                return false;

        }
        return false;
    }


    public boolean find(String user_name, String email, String password) {
        for (int x = 0; x < arr.size(); x++) {
            if (Objects.equals(arr.get(x).email, email) || Objects.equals(arr.get(x).user_name, user_name)) {
                return false;
            } else {
                User u = new User(user_name, email, password);
                arr.add(u);
                user = x;
                return true;
            }
        }

        if (arr.size() == 0) {
            User u = new User(user_name, email, password);
            arr.add(u);
            return true;
        }
        return false;
    }


    void search() {
        System.out.println("Enter your query:");

        String question;

        int choose;

        question = myObj.next();

        if (question.equals("Vodafone")) {
            System.out.println("Choose one of Services:");
            System.out.println("1- Mobile recharge services");
            System.out.println("2- Internet Payment services");
            choose = myObj.nextInt();
            switch (choose) {
                case 1:
                    service = new MobileRecharge().get_service(1);
                    service.getinfo();
                    payment(service.getServiceprice());
                    break;

                case 2:
                    service = new InternetPaymentService().get_service(1);
                    service.getinfo();
                    payment(service.getServiceprice());
                    break;
            }
        } else if (question.equals("Etisalat")) {
            System.out.println("Choose one of Services:");
            System.out.println("1- Mobile recharge services");
            System.out.println("2- Internet Payment services");
            choose = myObj.nextInt();
            switch (choose) {
                case 1:
                    service = new MobileRecharge().get_service(3);
                    service.getinfo();
                    payment(service.getServiceprice());
                    break;

                case 2:
                    service = new InternetPaymentService().get_service(3);
                    service.getinfo();
                    payment(service.getServiceprice());
                    break;
            }
        } else if (question.equals("We")) {
            System.out.println("Choose one of Services:");
            System.out.println("1- Mobile recharge services");
            System.out.println("2- Internet Payment services");
            choose = myObj.nextInt();
            switch (choose) {
                case 1:
                    service = new MobileRecharge().get_service(2);
                    service.getinfo();
                    payment(service.getServiceprice());
                    break;

                case 2:
                    service = new InternetPaymentService().get_service(2);
                    service.getinfo();
                    payment(service.getServiceprice());
                    break;
            }
        } else if (question.equals("Orange")) {
            System.out.println("Choose one of Services:");
            System.out.println("1- Mobile recharge services");
            System.out.println("2- Internet Payment services");
            choose = myObj.nextInt();
            switch (choose) {
                case 1:
                    service = new MobileRecharge().get_service(4);
                    service.getinfo();
                    payment(service.getServiceprice());
                    break;

                case 2:
                    service = new InternetPaymentService().get_service(4);
                    service.getinfo();
                    payment(service.getServiceprice());
                    break;
            }
        } else if (question.equals("Discounts")) {
            System.out.println("1- Cancer Hospital");
            System.out.println("2- Schools");
            System.out.println("3- NGOs");
            System.out.println("Enter number of organization:");
            choose = myObj.nextInt();
            service = new Donations().get_service(choose);
            service.getinfo();
            payment(service.getServiceprice());


        } else if (question.equals("landline")) {
            System.out.println("1- Monthly receipt");
            System.out.println("2- Quarter receipt");
            System.out.println("Enter period needed:");
            choose = myObj.nextInt();
            service = new Landline().get_service(choose);
            service.getinfo();
            payment(service.getServiceprice());


        }


    }


    void requestRefund() {
        String code, name, price;
        System.out.println("Enter Name of service:");
        name = myObj.next();
        System.out.println("Enter code number of operation:");
        code = myObj.next();
        System.out.println("Enter price of service:");
        price = myObj.next();

        Refund R = new Refund(name, price, code, user);
        adminControlleront.refundArr.add(R);


    }


    void checkDiscount() {

        for (int x = 0; x <= adminControlleront.Dis_arr.size(); x++) {
            if (adminControlleront.Dis_arr.size() == 0) {
                System.out.println("There is no available discount currently");
                break;
            }
            System.out.println(x + 1);
            System.out.println(adminControlleront.Dis_arr.get(x));
        }

    }


    void addFundsWallet() {
        System.out.println("Enter the amount");
        Float amount = myObj.nextFloat();
        Funds f = new Funds(arr.get(user).wallet);
        f.addFunds(amount);
    }


    void chooseService() {
        int chooseSer;
        int Type;
        System.out.println("Choose one of Services:");
        System.out.println("1- Mobile recharge services");
        System.out.println("2- Internet Payment services");
        System.out.println("3- Landline services");
        System.out.println("4- Donations services");
        chooseSer = myObj.nextInt();

        switch (chooseSer) {
            case 1:
                System.out.println("1- Vodafone mobile services");
                System.out.println("2- We mobile services");
                System.out.println("3- Etisalat mobile services");
                System.out.println("4- Orange mobile services");
                System.out.println("Enter name of company:");
                Type = myObj.nextInt();
                service = new MobileRecharge().get_service(Type);
                d2.applyDiscount(service, adminControlleront.Dis_arr.get(chooseSer - 1));
                d1.applyDiscount(service, adminControlleront.Dis_arr.get(4));
                service.getinfo();
                payment(service.getServiceprice());
                break;
            case 2:
                System.out.println("1- Vodafone internet services");
                System.out.println("2- We internet services");
                System.out.println("3- Etisalat internet services");
                System.out.println("4- Orange internet services");
                System.out.println("Enter name of company:");
                Type = myObj.nextInt();
                service = new InternetPaymentService().get_service(Type);
                d2.applyDiscount(service, adminControlleront.Dis_arr.get(chooseSer - 1));
                d1.applyDiscount(service, adminControlleront.Dis_arr.get(4));
                service.getinfo();
                payment(service.getServiceprice());
                break;

            case 3:
                System.out.println("1- Monthly receipt");
                System.out.println("2- Quarter receipt");
                System.out.println("Enter period needed:");
                Type = myObj.nextInt();
                service = new Landline().get_service(Type);
                d2.applyDiscount(service, adminControlleront.Dis_arr.get(chooseSer));
                d1.applyDiscount(service, adminControlleront.Dis_arr.get(4));
                service.getinfo();
                payment(service.getServiceprice());
                break;

            case 4:
                System.out.println("1- Cancer Hospital");
                System.out.println("2- Schools");
                System.out.println("3- NGOs");
                System.out.println("Enter name of organization:");
                Type = myObj.nextInt();
                service = new Donations().get_service(Type);
                d2.applyDiscount(service, adminControlleront.Dis_arr.get(chooseSer));
                d1.applyDiscount(service, adminControlleront.Dis_arr.get(4));
                service.getinfo();
                payment(service.getServiceprice());
                break;

            default:
                System.exit(0);

        }
        adminControlleront.Dis_arr.set(4,0);


    }

    public void payment(Float amount) {
        int choose;
        System.out.println("Choose Payment method:");
        System.out.println("1- Wallet");
        System.out.println("2- Cash");
        System.out.println("3- Credit Card");
        choose = myObj.nextInt();
        switch (choose) {
            case 1:
                p = arr.get(user).wallet;
                p.pay(amount);
                notifyAmount();
                break;
            case 2:
                p = new Cash();
                p.pay(amount);
                break;
            case 3:
                p = new CreditCard();
                p.pay(amount);
                break;
        }
    }


    @Override
    public void notifyAmount() {

        arr.get(user).update(arr.get(user).wallet.currentCredit + "");
    }

    @Override
    public void notifyRefund() {
        for (int i = 0; i < adminControlleront.accepted.size(); i++) {
            if (adminControlleront.accepted.get(i) == user) {
                arr.get(user).update("Your Refund is Accepted!");
            }

        }
        for (int i = 0; i < adminControlleront.refused.size(); i++) {
            if (adminControlleront.refused.get(i) == user) {
                arr.get(user).update("Your Refund is Refused!");
            }

        }
    }
}
