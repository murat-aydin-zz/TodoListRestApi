package com.example.huawei.huaweiapi.controller;

import com.example.huawei.huaweiapi.command.ItemListCommand;
import com.example.huawei.huaweiapi.constant.Constant;
import com.example.huawei.huaweiapi.model.ServiceResponse;
import com.example.huawei.huaweiapi.service.ItemListService;
import com.example.huawei.huaweiapi.service.ItemListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ListController {


    @Autowired
    private ItemListService itemListService;

    @GetMapping("/lists")
    public ResponseEntity<Object> getAllLists(Pageable pageable) {
        ServiceResponse<Page<ItemListCommand>> response = new ServiceResponse<>();
        response.setData(itemListService.findAll(pageable));
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/lists/user/{userId}")
    public ResponseEntity<Object> getUsersList(@PathVariable Long userId){
        ServiceResponse<List<ItemListCommand>> response = new ServiceResponse<>();
        response.setData(itemListService.findByUserId(userId));
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);
       return responseEntity;
    }

    @PostMapping("/lists")
    public ResponseEntity<Object> createList(@Valid @RequestBody ItemListCommand itemListCommand) throws RuntimeException{
        ServiceResponse<ItemListCommand> response = new ServiceResponse<>();
        response.setData(itemListService.createList(itemListCommand));
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.CREATED.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.CREATED);

        return responseEntity;
    }

    @PutMapping("/lists/{listId}")
    public ResponseEntity<Object> updateList(@PathVariable Long listId, @Valid @RequestBody ItemListCommand itemListCommand) {
        itemListCommand.setId(listId);
        ItemListCommand item = itemListService.updateList(itemListCommand);
        ServiceResponse<ItemListCommand> response = new ServiceResponse<>();
        response.setData(item);
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.CREATED.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.CREATED);

        return responseEntity;
    }


    @DeleteMapping("/lists/{listId}")
    public ResponseEntity<Object> deleteList(@PathVariable Long listId) {
        itemListService.delete(listId);
        ServiceResponse<ItemListCommand> response = new ServiceResponse<>();
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);

        return responseEntity;
    }


}