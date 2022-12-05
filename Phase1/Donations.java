public class Donations extends Service{


 public  Donations get_service(int donationType){
       Service_Factory Ser=new Service_creator();
        return Ser.Creator_D(donationType);


   }

    @Override
    public Float getServiceprice(){

        return obj.servicePrice-(obj.servicePrice*discountPrice/100);
    }

    @Override
    public void dis(Float D) {

    }


}
