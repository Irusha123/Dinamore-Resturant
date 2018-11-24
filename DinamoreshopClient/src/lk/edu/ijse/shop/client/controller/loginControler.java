/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.client.controller;

import lk.edu.ijse.shop.client.proxy.ProxyHandler;
import lk.edu.ijse.shop.common.dto.loginDto;
import lk.edu.ijse.shop.common.service.ServiceFactory;
import lk.edu.ijse.shop.common.service.custom.loginService;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public class loginControler {
    public static boolean addUser(loginDto dto) throws Exception{
    loginService cService=(loginService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.LOGIN);
         return cService.addUser(dto);
    }
    public static List<loginDto> viewAll() throws Exception{
    loginService cService=(loginService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.LOGIN);
         return cService.viewAll();
    }
    
    public static boolean addChef(loginDto dto) throws Exception{
    loginService cService=(loginService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.LOGIN);
         return cService.addChef(dto);
    }
    public static List<loginDto> getAllChef() throws Exception{
    loginService cService=(loginService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.LOGIN);
         return cService.getAllChef();
    }
}
