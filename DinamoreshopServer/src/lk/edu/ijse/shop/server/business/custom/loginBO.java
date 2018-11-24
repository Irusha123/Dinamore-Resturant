/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.business.custom;

import lk.edu.ijse.shop.common.dto.loginDto;
import lk.edu.ijse.shop.server.business.SuperBO;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public interface loginBO extends SuperBO{
    
    public boolean addUser(loginDto dto)throws Exception;
    public List<loginDto> viewAll()throws Exception;
    
    public boolean addChef(loginDto dto)throws Exception;
    public List<loginDto> getAllChef()throws Exception;
}
