/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.repository.custom.impl;

import lk.edu.ijse.shop.common.dto.OrdersDto;
import lk.edu.ijse.shop.server.entity.Orders;
import lk.edu.ijse.shop.server.repository.custom.CallCenterRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.hibernate.Session;

/**
 *
 * @author Irusha Yujitha
 */
public class CallCenterRepositoryImpl implements CallCenterRepository{
    private Connection connection;
    private final static ReentrantReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
    
    public CallCenterRepositoryImpl(){
        
    }

    @Override
    public boolean save(Orders t) throws Exception {
        try {
            RW_LOCK.writeLock().lock();
          String Sql="INSERT INTO orders values('"+t.getOid()+"','"+t.getDate()+"','"+t.getQty()+"','"+t.getItemCode()+"','"+t.getCid()+"','"+t.getName()+"','"+t.getAddress()+"','"+t.getTel()+"','"+t.getType()+"','"+t.getStartTime()+"','"+t.getEndTime()+"','"+t.getChefName()+"')";
          Statement statement=connection.createStatement();
          int res=statement.executeUpdate(Sql);
          try{Thread.sleep(5000);}catch(InterruptedException we){}
            return res>0;
        } finally {
            RW_LOCK.writeLock().unlock();
        }
    }

    @Override
    public Orders search(String id) throws Exception {
        String Sql="SELECT * from Orders where oid='"+id+"'";
        Statement statement=connection.createStatement();
        ResultSet res=statement.executeQuery(Sql);
        if(res.next()){
             Orders orders=new Orders(res.getString("oid"),res.getString("date"),res.getInt("qty"),res.getString("itemCode"),res.getString("cid"),res.getString("custName"),res.getString("custAddress"),res.getString("custTel"),res.getString("Ttype"),res.getString("startTime"),res.getString("endTime"),res.getString("chefName"));
             return orders;
        }
        return null;
    }

    @Override
    public boolean update(Orders t) throws Exception {
            try {
            RW_LOCK.writeLock().lock();
             String Sql="Update Orders set date='"+t.getDate()+"', qty='"+t.getQty()+"',itemCode='"+t.getItemCode()+"',cid='"+t.getCid()+"',custName='"+t.getName()+"',custAddress='"+t.getAddress()+"',custTel='"+t.getTel()+"',Ttype='"+t.getType()+"',startTime='"+t.getStartTime()+"', endTime='"+t.getEndTime()+"' where oid='"+t.getOid()+"' ";
          Statement statement=connection.createStatement();
          int res=statement.executeUpdate(Sql);
          try{Thread.sleep(5000);}catch(InterruptedException we){}
            return res>0;
        
          } finally {
            RW_LOCK.writeLock().unlock();
        }
    }

    @Override
    public void delete(String id) throws Exception {
       
    }

    @Override
    public List<Orders> view() throws Exception {
         String Sql="SELECT * from Orders ";
        Statement statement=connection.createStatement();
        ResultSet res=statement.executeQuery(Sql);
        ArrayList<Orders>list=new ArrayList<>();
        while(res.next()){
            
            Orders orders=new Orders(res.getString("oid"),res.getString("date"),res.getInt("qty"),res.getString("itemCode"),res.getString("cid"),res.getString("custName"),res.getString("custAddress"),res.getString("custTel"),res.getString("Ttype"),res.getString("startTime"),res.getString("endTime"),res.getString("chefName"));
           
            list.add(orders);
         }
        return list;
        
    }

   

    @Override
    public List<Orders> searchDate(String date) throws Exception {
       String Sql="SELECT * from Orders where date='"+date+"'";
        Statement statement=connection.createStatement();
        ResultSet res=statement.executeQuery(Sql);
        ArrayList<Orders>list=new ArrayList<>();
        while(res.next()){
            
            Orders orders=new Orders(res.getString("oid"),res.getString("date"),res.getInt("qty"),res.getString("itemCode"),res.getString("cid"),res.getString("custName"),res.getString("custAddress"),res.getString("custTel"),res.getString("Ttype"),res.getString("startTime"),res.getString("endTime"),res.getString("chefName"));
            System.out.println(" searchDate query "+orders.getOid());
            list.add(orders);
         }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

  
}


