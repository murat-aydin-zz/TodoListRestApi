package com.example.huawei.huaweiapi.service;

import com.example.huawei.huaweiapi.command.ItemCommand;
import com.example.huawei.huaweiapi.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {

     List<ItemCommand> findItemByItemListId(Long itemListId)  throws ResourceNotFoundException;

     ItemCommand createItem(Long listId,ItemCommand itemCommand) throws ResourceNotFoundException;

     void delete(Long itemListId,Long itemId) throws ResourceNotFoundException;
}
