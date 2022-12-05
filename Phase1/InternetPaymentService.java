public class InternetPaymentService extends Service {

    Discounts D=new SpecificDiscount();

    public InternetPaymentService get_service(int Type){
        Service_Factory Ser=new Service_creator();
        return Ser.Creator_I(Type);
    }

    @Override
    public Float getServiceprice(){

        return obj.servicePrice-(obj.servicePrice*discountPrice/100);
    }
    public  void dis (Float dp){
       this.discountPrice = dp;



    }


}
