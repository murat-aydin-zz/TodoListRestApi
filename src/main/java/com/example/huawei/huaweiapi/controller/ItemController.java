package com.example.huawei.huaweiapi.controller;

import com.example.huawei.huaweiapi.command.ItemCommand;
import com.example.huawei.huaweiapi.constant.Constant;
import com.example.huawei.huaweiapi.model.ServiceResponse;
import com.example.huawei.huaweiapi.service.ItemService;
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
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/lists/{listId}/items")
    public ResponseEntity<Object> getAllItemsByPostId(@PathVariable(value = "listId") Long listId) {
        ServiceResponse<List<ItemCommand>> response = new ServiceResponse<>();
        response.setData(itemService.findItemByItemListId(listId));
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);
        return responseEntity;

    }

    @PostMapping("/lists/{listId}/items")
    public ResponseEntity<Object> createItem(@PathVariable (value = "listId") Long listId,
                              @Valid @RequestBody ItemCommand itemCommand) {
        ServiceResponse<ItemCommand> response = new ServiceResponse<>();
        response.setData(itemService.createItem(listId,itemCommand));
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);
        return responseEntity;
    }


    @DeleteMapping("/lists/{listId}/items/{itemId}")
    public ResponseEntity<Object> deleteItem(@PathVariable (value = "listId") Long listId,
                                           @PathVariable (value = "itemId") Long itemId) {
        itemService.delete(listId,itemId);
        ServiceResponse<ItemCommand> response = new ServiceResponse<>();
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);
        return responseEntity;

    }

}