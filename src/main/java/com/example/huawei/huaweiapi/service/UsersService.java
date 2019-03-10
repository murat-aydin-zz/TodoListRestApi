package com.example.huawei.huaweiapi.service;

import com.example.huawei.huaweiapi.command.UsersCommand;
import com.example.huawei.huaweiapi.domain.Users;
import com.example.huawei.huaweiapi.exception.ResourceNotFoundException;
import com.example.huawei.huaweiapi.model.UsersModel;

public interface UsersService {

    UsersCommand createUser(UsersModel usersModel) throws Exception;

    UsersCommand findById(Long id) throws ResourceNotFoundException;
}
