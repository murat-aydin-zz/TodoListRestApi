package com.example.huawei.huaweiapi.converter;

import com.example.huawei.huaweiapi.command.ItemListCommand;
import com.example.huawei.huaweiapi.domain.ItemList;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ListToListCommandConverter implements Converter<ItemList, ItemListCommand> {
    @Override
    public ItemListCommand convert(ItemList itemList) {
        if (itemList == null)
            return null;
        ItemListCommand itemListCommand = new ItemListCommand();

        itemListCommand.setId(itemList.getId());
        itemListCommand.setName(itemList.getName());
        itemListCommand.setUserId(itemList.getUser().getId());
        itemListCommand.setCreatedAt(itemList.getCreatedAt());
        itemListCommand.setUpdatedAt(itemList.getUpdatedAt());

        return itemListCommand;
    }
}
