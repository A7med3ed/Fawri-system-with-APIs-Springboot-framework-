public class Refund {

    public Refund(String serviceName,String servicePrice,String serviceCode,int userNum) {
    this.serviceName = serviceName;
    this.servicePrice=servicePrice;
    this.serviceCode=serviceCode;
    this.userNum=userNum;
}
    private String serviceName;



    private String servicePrice;
    private String serviceStatus;
    private String serviceCode;

    int userNum;
    public String getServiceName() {
        return serviceName;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }
    public String getServiceCode() {
        return serviceCode;
    }
    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
