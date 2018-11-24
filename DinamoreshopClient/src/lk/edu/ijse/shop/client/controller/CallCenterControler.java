/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.client.controller;

import lk.edu.ijse.shop.client.proxy.ProxyHandler;
import lk.edu.ijse.shop.common.dto.OrdersDto;
import lk.edu.ijse.shop.common.observer.CustomerObserver;
import lk.edu.ijse.shop.common.service.ServiceFactory;
import lk.edu.ijse.shop.common.service.custom.CallCenterService;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public class CallCenterControler {
    public static boolean addOrder(OrdersDto ordersDto) throws Exception{
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS);
         return centerService.addOrder(ordersDto);
 }
    public static List<OrdersDto> viewOrders() throws Exception{
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS); 
         return centerService.viewAll();
 }
      public static boolean updateOrder(OrdersDto ordersDto) throws Exception{
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS);
         return centerService.updatteOrder(ordersDto);
 }
      public static OrdersDto searchOrder(String  id) throws Exception{
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS);
         return centerService.searchOrder(id);
 }
    
    public static boolean customerObs(CustomerObserver customerObserver) throws Exception{
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS);
         return centerService.addCustomerObserver(customerObserver);
 }

     public static List<OrdersDto> searchDate(String date) throws Exception{
         
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS); 
         return centerService.searchDate(date);
 }
     
     public static boolean reserve(String id)throws Exception{
               
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS); 
         return centerService.reserveCustomer(id);        
     }
      public static boolean release(String id)throws Exception{
               
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS); 
         return centerService.releaseCustomer(id);        
     }
      
       public static OrdersDto takeOrders()throws Exception{
               
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS); 
         return centerService.takeOrder();        
     }
        public static void addToQue(OrdersDto ordersDto) throws Exception{
    CallCenterService centerService=(CallCenterService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ORDERS);
          centerService.addToQue(ordersDto);
 }
    
}
