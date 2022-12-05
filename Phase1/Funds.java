public class Funds implements FundsInterface{
    Wallet w;
    public Funds(Wallet w){
        this.w=w;
    }
    public void addFunds(Float amount){
        w.c.pay(amount);
        w.currentCredit+=amount;
        System.out.println("succesfull operation");

    }
}
