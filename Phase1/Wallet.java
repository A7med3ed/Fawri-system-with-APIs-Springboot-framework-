public class Wallet implements Payment{
    protected double currentCredit = 0.0;
    protected CreditCard c =new CreditCard();
    public void pay(Float amount){

        if(currentCredit < amount || currentCredit ==0){
            System.out.println("not enough credit");
        }
        else {
            currentCredit-=amount;
            System.out.println("successfully payment");
        }
    }
}
