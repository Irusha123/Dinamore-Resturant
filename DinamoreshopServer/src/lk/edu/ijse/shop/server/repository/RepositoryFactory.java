/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.repository;

import lk.edu.ijse.shop.server.repository.custom.impl.CallCenterRepositoryImpl;
import lk.edu.ijse.shop.server.repository.custom.impl.ItemRepositoryImpl;
import lk.edu.ijse.shop.server.repository.custom.impl.loginRepositoryImpl;

/**
 *
 * @author Irusha Yujitha
 */
public class RepositoryFactory {
    private static RepositoryFactory repositoryFactory;
    
    private RepositoryFactory(){
        
    }
    public enum BOTypes{
        CUSTOMER,ORDERS,ITEM,LOGIN
    }
    public static RepositoryFactory getInstance(){
        if (repositoryFactory==null) {
            repositoryFactory=new RepositoryFactory();
        }
        return repositoryFactory;
    }
    public SuperRepository getBOTypes(BOTypes types){
        switch(types){
            case LOGIN:return new loginRepositoryImpl();
            case ITEM: return new ItemRepositoryImpl();
            case ORDERS:return new CallCenterRepositoryImpl();
            default:return null;
        }
    }
}
