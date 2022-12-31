package com.fawry_api.fawry.Controller;

import com.fawry_api.fawry.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
@Component
public class RefundController {
        @Autowired
                UserController userController;
    public void removeAccepted(){
        for (User u : userController.arr) {
            for (int i = 0; i <userController.serviceController.adminControlleront.accepted.size() ; i++) {
                if(Objects.equals(u.user_name, userController.serviceController.adminControlleront.accepted.get(i).getUserName())){
                    for (int j = 0; j < u.operationlist.size(); j++) {
                        if(Objects.equals(u.operationlist.get(i).getId(),userController.serviceController.adminControlleront.accepted.get(i).opID)){
                            u.operationlist.remove(i);
                        }
                    }
                }
            }
        }
    }
}
