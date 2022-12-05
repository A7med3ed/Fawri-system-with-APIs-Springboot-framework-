import java.util.Scanner;

public class CreditCard implements Payment{
    Scanner myobj =new Scanner(System.in);
    public void pay(Float amount){
        System.out.print("enter card number: ");
        String num = myobj.nextLine();
        System.out.println(amount);



    }
}
