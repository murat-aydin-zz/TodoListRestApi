package com.example.huawei.huaweiapi.converter;

import com.example.huawei.huaweiapi.command.ItemListCommand;
import com.example.huawei.huaweiapi.domain.ItemList;
import com.example.huawei.huaweiapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ListCommandToListConverter implements Converter<ItemListCommand, ItemList> {

    @Autowired
    UsersRepository usersRepository;


    @Override
    public ItemList convert(ItemListCommand itemListCommand) {
        if(itemListCommand == null)
            return null;
        ItemList itemList = new ItemList();
        itemList.setName(itemListCommand.getName());

        if(itemListCommand.getUserId() != null)
            itemList.setUser(usersRepository.findById(itemListCommand.getUserId()).get());

        return itemList;
    }
}
