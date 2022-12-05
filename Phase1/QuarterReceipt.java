import java.util.Scanner;

public class QuarterReceipt extends Landline{
    Scanner myobj =new Scanner(System.in);

    public QuarterReceipt(){
        obj =new Form();
        servicePrice = 123.0;

    }
    public void getinfo(){
        System.out.println("enter your phone number: ");
        obj.phoneNumber = myobj.nextLine();
        System.out.println("enter your name: ");
        obj.userName = myobj.nextLine();
        System.out.println("enter nearest branch from your home: ");
        obj.nearest_branch = myobj.nextLine();
        System.out.println("enter the amount payed: ");
        obj.servicePrice = myobj.nextFloat();
        System.out.println("enter your zip code: ");
        obj.zipCode = myobj.nextInt();

    }

}
