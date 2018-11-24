/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.service.custom.impl;

import lk.edu.ijse.shop.common.dto.loginDto;
import lk.edu.ijse.shop.common.service.custom.loginService;
import lk.edu.ijse.shop.server.business.BuisnessFactory;
import lk.edu.ijse.shop.server.business.custom.loginBO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public class loginServiceImpl extends UnicastRemoteObject implements loginService{
    private loginBO bo;
        
    public loginServiceImpl()throws RemoteException{
      bo=(loginBO) BuisnessFactory.getInstance().getBOTypes(BuisnessFactory.BOTypes.LOGIN);
    }
    
    @Override
    public boolean addUser(loginDto dto) throws Exception {
       return bo.addUser(dto);
    }

    @Override
    public List<loginDto> viewAll() throws Exception {
       return bo.viewAll();
    }

    @Override
    public boolean addChef(loginDto dto) throws Exception {
        return bo.addChef(dto);
    }

    @Override
    public List<loginDto> getAllChef() throws Exception {
        return bo.getAllChef();
    }
    
}
