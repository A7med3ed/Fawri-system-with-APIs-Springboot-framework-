import java.util.Scanner;

public class main {
    static Scanner myObj = new Scanner(System.in);
    static UserBound Ubound = new UserBound();
    static AdminBound Abound = new AdminBound();


    static public void authenticate() {

        boolean check = false;
        int auth;
        System.out.println("Chose one of options:");
        System.out.println("1- sign in");
        System.out.println("2- sign up");
        System.out.println("Enter number of choose:");
        auth = myObj.nextInt();

        if (auth == 1) {
            check = Ubound.sign_in();
            if (!check) {
                System.out.println("This doesn't found!");
                authenticate();
            }
        } else if (auth == 2) {
            check = Ubound.sign_up();
            if (!check) {
                System.out.println("This user registered before!");
                authenticate();
            }
        } else {
            System.exit(0);
        }

        if (check) {
            System.out.println("Successful Operation!");
        }


    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1- Admin");
            System.out.println("2- User");
            int choose;
            choose = myObj.nextInt();

            switch (choose) {
                case 1:
                    while (true) {
                        Abound.ChooseServices();
                        System.out.println("Would you like to continue as admin");
                        System.out.println("Choose: ");
                        System.out.println("1-Yes");
                        System.out.println("2-No");
                        int ans = myObj.nextInt();
                        if (ans == 2) {
                            break;
                        }

                    }
                    break;
                case 2:
                    authenticate();
                    Ubound.notification();
                    while (true) {
                        Ubound.ChooseServices();
                        System.out.println("Would you like to continue as user?");
                        System.out.println("Choose: ");
                        System.out.println("1-Yes");
                        System.out.println("2-No");

                        int ans = myObj.nextInt();
                        if (ans == 2)
                        {
                            break;
                        }

                    }
                    break;
                default:
                    System.exit(0);
            }
            System.out.println("would you like to continue in the app?");
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
