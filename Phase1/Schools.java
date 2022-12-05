import java.util.Scanner;

public class Schools extends Donations{
    Scanner myobj =new Scanner(System.in);

    public Schools(){
        obj =new Form();

    }
    public void getinfo(){
        System.out.println("enter your phone number: ");
        obj.phoneNumber = myobj.nextLine();
        System.out.println("enter your name: ");
        obj.userName = myobj.nextLine();
        System.out.println("enter the amount payed: ");
        obj.servicePrice = myobj.nextFloat();


    }

}
