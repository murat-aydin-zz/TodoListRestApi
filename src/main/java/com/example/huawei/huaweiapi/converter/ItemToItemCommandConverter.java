package com.example.huawei.huaweiapi.converter;

import com.example.huawei.huaweiapi.command.ItemCommand;
import com.example.huawei.huaweiapi.domain.Item;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemCommandConverter implements Converter<Item, ItemCommand> {

    @Override
    public ItemCommand convert(Item item) {
        if(item == null)
            return null;

        ItemCommand itemCommand = new ItemCommand();
        itemCommand.setId(item.getId());
        itemCommand.setName(item.getName());
        itemCommand.setDescription(item.getDescription());
        itemCommand.setStatus(item.getStatus());
        itemCommand.setDeadline(item.getDeadline());
        itemCommand.setItemListId(item.getItemList().getId());

        return itemCommand;
    }
}
