import java.util.Scanner;

public class OverallDiscount extends Discounts{
   Scanner myObj = new Scanner(System.in);

    @Override
    public void applyDiscount(Service ser,int f) {
        ser.discountPrice += f;



    }
}
