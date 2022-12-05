public class Landline extends Service{
    int phoneNum;

    public Landline get_service(int receiptType){
        Service_Factory Ser=new Service_creator();
        return Ser.Creator_L(receiptType);


    }
    @Override
    public Float getServiceprice(){
        return obj.servicePrice-(obj.servicePrice*discountPrice/100);
    }

    @Override
    public void dis(Float D) {

    }
}
