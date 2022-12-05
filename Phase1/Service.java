public  abstract class Service {
    Float discountPrice=(float)0;
    double servicePrice;
    Form obj ;
    public void getinfo(){}
    public abstract Service get_service(int Type);
    public abstract Float getServiceprice();
    // public  abstract void dis (Discounts D);


    public abstract void dis(Float D);
}
