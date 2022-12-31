package com.fawry_api.fawry.Controller.Factory;

import com.fawry_api.fawry.Controller.Services.Donations;
import com.fawry_api.fawry.Controller.Services.InternetPaymentServices;
import com.fawry_api.fawry.Controller.Services.Landline;
import com.fawry_api.fawry.Controller.Services.MobileRecharge;

public interface Service_Factory {

     Donations Creator_D(int type);
     MobileRecharge Creator_M(int type);
     Landline Creator_L(int type);
     InternetPaymentServices Creator_I(int type);
}
