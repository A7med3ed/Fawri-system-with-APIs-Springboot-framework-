import java.util.Scanner;

public class AdminBound {
    AdminController cont = AdminController.getInstance();
    Scanner myObj = new Scanner(System.in);

    public void ChooseServices() {
        while (true) {
            System.out.println("Choose Needed service");
            System.out.println("1- List Refunds");
            System.out.println("2- Add Discount");

            int choose;
            choose = myObj.nextInt();
            switch (choose) {
                case 1:
                    cont.listRefunds();
                    break;
                case 2:
                    cont.addDiscount();
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
