import java.util.Scanner;

public class SpecificDiscount extends Discounts{
    Scanner myObj = new Scanner(System.in);
    protected Float percentage=(float)0 ;
    @Override
    public void applyDiscount(Service ser,int f) {
         ser.discountPrice += f;
    }
}
