package com.example.huawei.huaweiapi.service;

import com.example.huawei.huaweiapi.command.UsersCommand;
import com.example.huawei.huaweiapi.converter.UsersCommandToUsersConverter;
import com.example.huawei.huaweiapi.converter.UsersToUsersCommandConverter;
import com.example.huawei.huaweiapi.domain.Users;
import com.example.huawei.huaweiapi.exception.ResourceNotFoundException;
import com.example.huawei.huaweiapi.model.UsersModel;
import com.example.huawei.huaweiapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersCommandToUsersConverter usersCommandToUsersConverter;

    @Autowired
    UsersToUsersCommandConverter usersToUsersCommandConverter;

    @Override
    public UsersCommand createUser(UsersModel usersModel) throws Exception {
        UsersCommand usersCommand = new UsersCommand();
        usersCommand.setUserName(usersModel.getUserName());
        usersCommand.setPassword(usersModel.getPassword());
        usersCommand.setActive(usersModel.getActive());
       Users users =  usersRepository.save(usersCommandToUsersConverter.convert(usersCommand));
       if(users == null)
           throw new Exception();
       return usersToUsersCommandConverter.convert(users);
    }

    @Override
    public UsersCommand findById(Long id) throws ResourceNotFoundException {
       return usersRepository.findById(id).map(users -> {
           return usersToUsersCommandConverter.convert(users);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found!"));

    }
}
