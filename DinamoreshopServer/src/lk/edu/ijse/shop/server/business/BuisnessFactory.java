/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.business;

import lk.edu.ijse.shop.server.business.custom.impl.CallCenterBOImpl;
import lk.edu.ijse.shop.server.business.custom.impl.ItemBOImpl;
import lk.edu.ijse.shop.server.business.custom.impl.loginBOImpl;

/**
 *
 * @author Irusha Yujitha
 */
public class BuisnessFactory {
    private static BuisnessFactory buisnessFactory;
    
    private BuisnessFactory(){
        
    }
    public enum BOTypes{
        CUSTOMER,ORDERS,ITEM,LOGIN
    }
    public static BuisnessFactory getInstance(){
        if (buisnessFactory==null) {
            buisnessFactory=new BuisnessFactory();
        }
        return buisnessFactory;
    }
    public SuperBO getBOTypes(BOTypes types){
      
        switch(types){
            case LOGIN:return new loginBOImpl();
            case ITEM : return new ItemBOImpl();
            case ORDERS : return new CallCenterBOImpl();
            default:return null;
        }
    }
}
