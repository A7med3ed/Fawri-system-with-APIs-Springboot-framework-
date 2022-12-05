public class Service_creator implements Service_Factory{

    @Override
    public Donations Creator_D(int type) {
        switch (type) {
            case 1:

                return new Schools();
            case 2:

                return new CancerHospital();
            case 3:
                return new NGOs();


        }
        return null;
    }

    @Override
   public MobileRecharge Creator_M(int type) {
        switch (type) {
            case 1:
                return new VodafoneMobile();

            case 2:
                return new WeMobile();

            case 3:
                return new EtisalatMobile();

            case 4:
                return new OrangeMobile();

        }
        return null;
    }

    @Override
   public Landline Creator_L(int type) {
        switch (type) {
            case 1:
                return new MonthlyReceipt();

            case 2:
                return new QuarterReceipt();

        }
        return null;
    }

    @Override
    public InternetPaymentService Creator_I(int type) {
        switch (type) {
            case 1:
                return new VodafoneInternet();

            case 2:
                return new WeInternet() ;

            case 3:

                return new EtisalatInternet();
            case 4:
                return new OrangeInternet();

        }
        return null;
    }
}
