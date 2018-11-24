/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.business.custom.impl;

import lk.edu.ijse.shop.common.dto.OrdersDto;
import lk.edu.ijse.shop.server.business.custom.CallCenterBO;
import lk.edu.ijse.shop.server.entity.Orders;
import lk.edu.ijse.shop.server.repository.RepositoryFactory;
import lk.edu.ijse.shop.server.repository.custom.CallCenterRepository;
import lk.edu.ijse.shop.server.resource.DBConnecton;
import java.rmi.RemoteException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Irusha Yujitha
 */
public class CallCenterBOImpl implements CallCenterBO{
    private static CallCenterRepository callCenterRepository;
    
    public static Queue <OrdersDto> orderQ=new LinkedList<>();
    
    public static ArrayList<OrdersDto>processList=new ArrayList<>();
  
    public CallCenterBOImpl(){
        callCenterRepository=(CallCenterRepository) RepositoryFactory.getInstance().getBOTypes(RepositoryFactory.BOTypes.ORDERS);
    }
    
    @Override
    public void addToQue(OrdersDto ordersDto) throws Exception {
              orderQ.add(ordersDto);
    }

    @Override
    public List<OrdersDto> viewAll() throws Exception {
        Connection connection=DBConnecton.getConnection();
        callCenterRepository.setConnection(connection);
        
        List<Orders>list=callCenterRepository.view();
              
        List<OrdersDto>dtoLost=new ArrayList<>();
         if (list != null) {
        for (Orders orders : list) {
            OrdersDto od=new OrdersDto(
                orders.getOid(),
                orders.getDate(),
                orders.getQty(),
                orders.getItemCode(),
                orders.getCid(),
                orders.getName(),
                orders.getAddress(),
                orders.getTel(),
                orders.getType(),
                orders.getStartTime(),
                orders.getEndTime(),
                orders.getChefName()
           );
            dtoLost.add(od);
            
        }
        return dtoLost;
         }else{
             return null;
         }
        }

    

    @Override
    public OrdersDto searchOrder(String id) throws Exception {
        Connection connection=DBConnecton.getConnection();
        callCenterRepository.setConnection(connection);
         
        Orders orders= callCenterRepository.search(id);
        OrdersDto ordersDto=new OrdersDto(
                orders.getOid(),
                orders.getDate(),
                orders.getQty(),
                orders.getItemCode(),
                orders.getCid(),
                orders.getName(),
                orders.getAddress(),
                orders.getTel(),
                orders.getType(),
                orders.getStartTime(),
                orders.getEndTime(),
                orders.getChefName()
        );
        return ordersDto;
    }

    @Override
    public boolean updateOrder(OrdersDto ordersDto)throws Exception {
         Connection connection=DBConnecton.getConnection();
        callCenterRepository.setConnection(connection);
        Orders orders=new Orders(
                ordersDto.getOid(),
                ordersDto.getDate(),
                ordersDto.getQty(),
                ordersDto.getItemCode(),
                ordersDto.getCid(),
                ordersDto.getName(),
                ordersDto.getAddress(),
                ordersDto.getTel(),
                ordersDto.getType(),
                ordersDto.getStartTime(),
                ordersDto.getEndTime(),
                ordersDto.getChefName()
        );
        System.out.println("update Bo impl  "+orders.getOid());
        return callCenterRepository.update(orders);
    }

   

    @Override
    public List<OrdersDto> searchDate(String date) throws Exception {
        Connection connection=DBConnecton.getConnection();
        callCenterRepository.setConnection(connection);
         
        List<Orders>list=callCenterRepository.searchDate(date);
       
        List<OrdersDto>dtoLost=new ArrayList<>();
        for (Orders orders : list) {
            OrdersDto od=new OrdersDto(
                orders.getOid(),
                orders.getDate(),
                orders.getQty(),
                orders.getItemCode(),
                orders.getCid(),
                orders.getName(),
                orders.getAddress(),
                orders.getTel(),
                orders.getType(),
                orders.getStartTime(),
                orders.getEndTime(),
                orders.getChefName()
           );
            System.out.println("BO IMPL "+orders.getOid());
            dtoLost.add(od);
            
        }
        return dtoLost;
    }

    @Override
    public OrdersDto takeOrder() throws Exception {
        OrdersDto ordersDto=null;
        if (!orderQ.isEmpty()) {
            ordersDto=orderQ.poll();
            processList.add(ordersDto);
        }
        return ordersDto;
    }

    @Override
    public boolean addOrder(OrdersDto ordersDto) throws Exception {
      Connection connection=DBConnecton.getConnection();
       callCenterRepository.setConnection(connection);
        Orders orders=new Orders(
                ordersDto.getOid(),
                ordersDto.getDate(),
                ordersDto.getQty(),
                ordersDto.getItemCode(),
                ordersDto.getCid(),
                ordersDto.getName(),
                ordersDto.getAddress(),
                ordersDto.getTel(),
                ordersDto.getType(),
                ordersDto.getStartTime(),
                ordersDto.getEndTime(),
                ordersDto.getChefName()
        );
         return callCenterRepository.save(orders);
     }

}
