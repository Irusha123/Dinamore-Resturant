/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.business.custom.impl;

import lk.edu.ijse.shop.common.dto.ItemDto;
import lk.edu.ijse.shop.server.business.custom.ItemBO;
import lk.edu.ijse.shop.server.entity.Item;

import lk.edu.ijse.shop.server.repository.RepositoryFactory;
import lk.edu.ijse.shop.server.repository.custom.ItemRepository;
import lk.edu.ijse.shop.server.resource.DBConnecton;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public class ItemBOImpl implements ItemBO{
    private static ItemRepository itemRepository;
    public ItemBOImpl(){
        itemRepository=(ItemRepository) RepositoryFactory.getInstance().getBOTypes(RepositoryFactory.BOTypes.ITEM);
    }
    @Override
    public ItemDto searchItem(String id) throws Exception {
        Connection connection=DBConnecton.getConnection();
        itemRepository.setConnection(connection);
        Item item= itemRepository.search(id);
        ItemDto itemDto=new ItemDto(
                item.getItemCode(),
                item.getItemName(),
                item.getQoh(),
                item.getUnitPrice()
        );
        return itemDto;
    }

    @Override
    public List<ItemDto> view() throws Exception {
        Connection connection=DBConnecton.getConnection();
        itemRepository.setConnection(connection); 
        List<Item> itemlList= itemRepository.view();
        List<ItemDto>itemsDto=new ArrayList<>();
        for (Item item : itemlList) {
            ItemDto itemDto=new ItemDto(
                item.getItemCode(),
                    item.getItemName(),
                    item.getQoh(),
                    item.getUnitPrice()
            );
            itemsDto.add(itemDto);
        } 
        return itemsDto;
    }
    
}
