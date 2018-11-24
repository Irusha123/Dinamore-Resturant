/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.client.observerImpl;

import lk.edu.ijse.shop.client.view.CheckStatus;
import lk.edu.ijse.shop.client.view.ChefDashboard;
import lk.edu.ijse.shop.client.view.Report;
import lk.edu.ijse.shop.common.observer.CustomerObserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.edu.ijse.shop.client.view.ChefDashboard;
import lk.edu.ijse.shop.client.view.Report;


/**
 *
 * @author Irusha Yujitha
 */
public class CustomerObserverImpl extends UnicastRemoteObject implements CustomerObserver{
    private ChefDashboard chefDashboard;
    private CheckStatus  checkstatus;
    private Report report;
    
    
    public CustomerObserverImpl(ChefDashboard chefDashboard)throws RemoteException{
        this.chefDashboard=chefDashboard;
    }

    public CustomerObserverImpl(Report report)throws RemoteException{
        this.report=report;
    }

   
    @Override
    public void update(String message) throws RemoteException {
        chefDashboard.setMessage(message);
    }
   
}
