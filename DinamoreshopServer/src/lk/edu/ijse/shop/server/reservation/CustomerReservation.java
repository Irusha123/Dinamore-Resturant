/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.reservation;


import lk.edu.ijse.shop.common.service.SuperService;
import lk.edu.ijse.shop.common.service.custom.CallCenterService;
import java.util.HashMap;

/**
 *
 * @author Irusha Yujitha
 */

public class CustomerReservation <T extends SuperService>{
    private HashMap<String, CallCenterService>reserveData=new HashMap<>();
    public boolean reserveCustomer(String id, CallCenterService customerController){
        if(reserveData.containsKey(id)){
            if(reserveData.get(id)==customerController){
                return  true;
            }
            return false;
        }else{
            reserveData.put(id, customerController);
            return true;
        }
    }
    public boolean releaseCustomer(String key, CallCenterService customerController){
        if (reserveData.containsKey(key)){
            reserveData.remove(key);
            return true;
        }else{
            return false;
        }
    }
}
