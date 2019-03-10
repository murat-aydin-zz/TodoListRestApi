package com.example.huawei.huaweiapi.controller;

import com.example.huawei.huaweiapi.command.UsersCommand;
import com.example.huawei.huaweiapi.constant.Constant;
import com.example.huawei.huaweiapi.model.ServiceResponse;
import com.example.huawei.huaweiapi.model.UsersModel;
import com.example.huawei.huaweiapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<Object> createUser(@RequestBody UsersModel usersModel) throws Exception {
        ServiceResponse<UsersCommand> response = new ServiceResponse<>();
        response.setData(usersService.createUser(usersModel));
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);
        return responseEntity;
    }

}
