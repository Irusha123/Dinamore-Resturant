/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.business.custom.impl;

import lk.edu.ijse.shop.common.dto.loginDto;
import lk.edu.ijse.shop.server.business.custom.loginBO;
import lk.edu.ijse.shop.server.entity.login;
import lk.edu.ijse.shop.server.repository.RepositoryFactory;
import lk.edu.ijse.shop.server.repository.custom.loginRepository;
import lk.edu.ijse.shop.server.resource.DBConnecton;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Irusha Yujitha
 */
public class loginBOImpl implements loginBO{
    private static loginRepository repository;
    
    public loginBOImpl(){
        repository=(loginRepository) RepositoryFactory.getInstance().getBOTypes(RepositoryFactory.BOTypes.LOGIN);
    }
    
    @Override
    public boolean addUser(loginDto dto) throws Exception {
       Connection connection=DBConnecton.getConnection();
        repository.setConnection(connection);
       login lo=new login(
               dto.getUser(),
               dto.getPassword()
       );
        return repository.addUser(lo);
    }

    @Override
    public List<loginDto> viewAll() throws Exception {
        Connection connection=DBConnecton.getConnection();
        repository.setConnection(connection);
        
      List<login> list=repository.viewAll();
      List<loginDto>dtoList=new ArrayList<>();
        for (login dto : list) {
            loginDto d=new loginDto(
                    dto.getUser(),
                    dto.getPassword()
            );
            dtoList.add(d);
        }
        return dtoList;
      
    }

    @Override
    public boolean addChef(loginDto dto) throws Exception {
       Connection connection=DBConnecton.getConnection();
        repository.setConnection(connection);
       login lo=new login(
               dto.getUser(),
               dto.getPassword()
       );
        return repository.addChef(lo);
    }

    @Override
    public List<loginDto> getAllChef() throws Exception {
         Connection connection=DBConnecton.getConnection();
        repository.setConnection(connection);
        
      List<login> list=repository.getAllChef();
      List<loginDto>dtoList=new ArrayList<>();
        for (login dto : list) {
            loginDto d=new loginDto(
                    dto.getUser(),
                    dto.getPassword()
            );
            dtoList.add(d);
        }
        return dtoList;
    }
    
}
