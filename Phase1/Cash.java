public class Cash implements Payment{
    public void pay(Float amount){
        System.out.print("paying in cash: ");
        System.out.println(amount);
    }
}
