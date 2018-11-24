/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.service.custom.impl;

import lk.edu.ijse.shop.common.dto.ItemDto;
import lk.edu.ijse.shop.common.service.custom.ItemService;
import lk.edu.ijse.shop.server.business.BuisnessFactory;
import lk.edu.ijse.shop.server.business.custom.ItemBO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService{
    private ItemBO itemBO;
    
    public ItemServiceImpl()throws RemoteException{
        itemBO=(ItemBO) BuisnessFactory.getInstance().getBOTypes(BuisnessFactory.BOTypes.ITEM);
    }
    @Override
    public ItemDto searchItem(String id) throws Exception {
       return itemBO.searchItem(id);
    }

    @Override
    public List<ItemDto> viewAllItem() throws Exception {
      return itemBO.view();
    }
    
}
