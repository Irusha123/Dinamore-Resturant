/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.startup;

import lk.edu.ijse.shop.server.service.impl.ServiceFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irusha Yujitha
 */
public class ServerStart {
    public static void main(String[] args) {
      try {
            Registry registry=LocateRegistry.createRegistry(5050);
            registry.rebind("chef",ServiceFactoryImpl.getInstance());
            System.out.println("Server starting");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
