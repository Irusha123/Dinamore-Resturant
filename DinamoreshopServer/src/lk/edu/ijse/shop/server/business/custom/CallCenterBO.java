/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.business.custom;

import lk.edu.ijse.shop.common.dto.OrdersDto;
import lk.edu.ijse.shop.common.observer.CustomerObserver;
import lk.edu.ijse.shop.server.business.SuperBO;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public interface CallCenterBO extends SuperBO{
    public void addToQue(OrdersDto ordersDto)throws Exception;
    public boolean addOrder(OrdersDto ordersDto)throws Exception;
    public List<OrdersDto>viewAll()throws Exception;
    public OrdersDto searchOrder(String id)throws Exception;
    public boolean updateOrder(OrdersDto ordersDto)throws Exception;
    
    public List<OrdersDto> searchDate(String date)throws Exception;
    public OrdersDto takeOrder()throws Exception;
    
    
}
