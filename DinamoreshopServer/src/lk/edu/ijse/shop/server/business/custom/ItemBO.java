/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.business.custom;

import lk.edu.ijse.shop.common.dto.ItemDto;
import lk.edu.ijse.shop.server.business.SuperBO;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public interface ItemBO extends SuperBO{
    public ItemDto searchItem(String id)throws Exception;
    public List<ItemDto> view()throws Exception;
}
