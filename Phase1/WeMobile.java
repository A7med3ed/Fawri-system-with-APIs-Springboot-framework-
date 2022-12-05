import java.util.Scanner;

public class WeMobile extends MobileRecharge{
    Scanner myobj =new Scanner(System.in);

    public WeMobile(){
        obj =new Form();

    }
    public void getinfo(){
        System.out.println("enter your phone number: ");
        obj.phoneNumber = myobj.nextLine();
        System.out.println("enter your address: ");
        obj.address = myobj.nextLine();
        System.out.println("enter your zip code: ");
        obj.zipCode = myobj.nextInt();
        System.out.println("enter the amount payed: ");
        obj.servicePrice = myobj.nextFloat();

    }

}
