/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.common.service;

import java.rmi.Remote;

/**
 *
 * @author Irusha Yujitha
 */
public interface ServiceFactory extends Remote{
    public enum ServiceTypes{
        CUSTOMER,ORDERS,ITEM,LOGIN
    }
    public SuperService getServiceType(ServiceTypes types)throws Exception;
}
