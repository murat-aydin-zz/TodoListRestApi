package com.example.huawei.huaweiapi.service;

import com.example.huawei.huaweiapi.command.ItemListCommand;
import com.example.huawei.huaweiapi.exception.ResourceNotFoundException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface ItemListService {

    ItemListCommand createList(ItemListCommand itemListCommand) throws RuntimeException;

    List<ItemListCommand> findByUserId(Long id) throws ResourceNotFoundException;

    PageImpl<ItemListCommand> findAll(Pageable pageable) throws ResourceNotFoundException;

    ItemListCommand updateList(ItemListCommand itemListCommand) throws ResourceNotFoundException;

    ItemListCommand findById(Long Id) throws ResourceNotFoundException;

    void delete(Long Id) throws ResourceNotFoundException;
}
