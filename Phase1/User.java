public class User implements Observer{
    public User(String user_name,String email,String password) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        wallet.currentCredit= Float.valueOf(0);
    }
    public User() {

    }

    protected String user_name;
    protected String email;
    protected String password;
    protected  Wallet wallet = new Wallet();
    protected String credit_num;



    @Override
    public void update(String massage) {
        System.out.println(massage);

    }



}