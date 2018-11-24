/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.client.controller;

import lk.edu.ijse.shop.client.proxy.ProxyHandler;
import lk.edu.ijse.shop.common.dto.ItemDto;
import lk.edu.ijse.shop.common.service.ServiceFactory;
import lk.edu.ijse.shop.common.service.custom.ItemService;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public class ItemControler {
     public static ItemDto serarchItm(String id) throws Exception{
     ItemService itemcenter=(ItemService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ITEM);
         return itemcenter.searchItem(id);
         }
     
     public static List<ItemDto> view() throws Exception{
     ItemService itemcenter=(ItemService) ProxyHandler.getInstanse().getServiceType(ServiceFactory.ServiceTypes.ITEM);
         return itemcenter.viewAllItem();
         }
}
