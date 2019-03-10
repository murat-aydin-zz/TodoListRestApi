package com.example.huawei.huaweiapi.converter;

import com.example.huawei.huaweiapi.command.ItemCommand;
import com.example.huawei.huaweiapi.domain.Item;
import com.example.huawei.huaweiapi.repository.ItemListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemCommandToItemConverter implements Converter<ItemCommand, Item> {

    @Autowired
    ItemListRepository itemListRepository;

    @Override
    public Item convert(ItemCommand itemCommand) {
       if(itemCommand == null)
           return null;

       Item item = new Item();
       item.setId(itemCommand.getId());
       item.setName(itemCommand.getName());
       item.setDescription(itemCommand.getDescription());
       item.setStatus(itemCommand.getStatus());
       item.setDeadline(itemCommand.getDeadline());
       item.setItemList(itemListRepository.findById(itemCommand.getItemListId()).get());

       return item;
    }
}
