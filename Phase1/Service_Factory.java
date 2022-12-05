public interface Service_Factory {

     Donations  Creator_D(int type);
     MobileRecharge Creator_M(int type);
     Landline Creator_L(int type);
     InternetPaymentService Creator_I(int type);
}
