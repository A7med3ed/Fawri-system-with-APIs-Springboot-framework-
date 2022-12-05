public class MobileRecharge extends Service{

   public MobileRecharge get_service(int Type){
      Service_Factory Ser=new Service_creator();
        return Ser.Creator_M(Type);


   }
    public Float getServiceprice(){

        return obj.servicePrice-(obj.servicePrice*discountPrice/100);
    }

    @Override
    public void dis(Float D) {

    }


}
