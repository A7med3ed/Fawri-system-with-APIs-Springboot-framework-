import java.util.Scanner;

public class EtisalatMobile extends MobileRecharge{

    Scanner myobj =new Scanner(System.in);

    public EtisalatMobile(){
        obj =new Form();

    }
    public void getinfo(){
        System.out.println("enter your phone number: ");
        obj.phoneNumber = myobj.nextLine();
        System.out.println("enter your name: ");
        obj.userName = myobj.nextLine();
        System.out.println("enter your address: ");
        obj.address = myobj.nextLine();

    }

}
