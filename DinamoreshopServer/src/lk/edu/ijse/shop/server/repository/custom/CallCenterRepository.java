/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.repository.custom;

import lk.edu.ijse.shop.common.dto.OrdersDto;
import lk.edu.ijse.shop.server.entity.Orders;
import lk.edu.ijse.shop.server.repository.SuperRepository;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public interface CallCenterRepository extends SuperRepository<Orders, String>{
    
    public List<Orders> searchDate(String date)throws Exception;
 
}
