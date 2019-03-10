package com.example.huawei.huaweiapi.service;

import com.example.huawei.huaweiapi.command.ItemCommand;
import com.example.huawei.huaweiapi.command.ItemListCommand;
import com.example.huawei.huaweiapi.converter.ItemCommandToItemConverter;
import com.example.huawei.huaweiapi.converter.ItemToItemCommandConverter;
import com.example.huawei.huaweiapi.domain.Item;
import com.example.huawei.huaweiapi.exception.ResourceNotFoundException;
import com.example.huawei.huaweiapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemListService itemListService;

    @Autowired
    ItemCommandToItemConverter itemCommandToItemConverter;

    @Autowired
    ItemToItemCommandConverter itemToItemCommandConverter;

    @Override
    public List<ItemCommand> findItemByItemListId(Long itemListId) throws ResourceNotFoundException {
        itemListService.findById(itemListId);

        return itemRepository.findItemByItemList_Id(itemListId).stream().map(item -> {
            return itemToItemCommandConverter.convert(item);
        }).collect(Collectors.toList());

         }

    @Override
    public ItemCommand createItem(Long listId, ItemCommand itemCommand) throws ResourceNotFoundException {
          ItemListCommand itemListCommand = itemListService.findById(listId);

          itemCommand.setItemListId(itemListCommand.getId());

          return itemToItemCommandConverter.convert(
                  itemRepository.save(itemCommandToItemConverter.convert(itemCommand)));


    }

    @Override
    public void delete(Long itemListId, Long itemId) throws ResourceNotFoundException {
        itemRepository.findItemByIdAndItemListId(itemId,itemListId).map(item ->{
            itemRepository.delete(item);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Not found any Item -> ID : " + itemId));
    }
}
