/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.service.impl;

import lk.edu.ijse.shop.common.service.ServiceFactory;
import lk.edu.ijse.shop.common.service.SuperService;
import lk.edu.ijse.shop.server.service.custom.impl.CallCenterServiceImpl;
import lk.edu.ijse.shop.server.service.custom.impl.ItemServiceImpl;
import lk.edu.ijse.shop.server.service.custom.impl.loginServiceImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Irusha Yujitha
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{
    private static ServiceFactory serviceFactory;
    private ServiceFactoryImpl()throws RemoteException{
        
    }
    @Override
    public SuperService getServiceType(ServiceTypes types) throws Exception {
        
        switch(types){
            case LOGIN:return new loginServiceImpl();
            case ITEM : return new ItemServiceImpl();
            case ORDERS:return new CallCenterServiceImpl();
            default:return null;
        }
    }
    public static ServiceFactory getInstance() throws RemoteException{
        if (serviceFactory==null) {
            serviceFactory= new ServiceFactoryImpl();
        }
        return serviceFactory;
    }
}
