package com.example.huawei.huaweiapi.service;

import com.example.huawei.huaweiapi.command.ItemListCommand;
import com.example.huawei.huaweiapi.converter.ListCommandToListConverter;
import com.example.huawei.huaweiapi.converter.ListToListCommandConverter;
import com.example.huawei.huaweiapi.domain.ItemList;
import com.example.huawei.huaweiapi.exception.ResourceNotFoundException;
import com.example.huawei.huaweiapi.repository.ItemListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemListServiceImpl implements ItemListService {
    @Autowired
    ListCommandToListConverter listCommandToListConverter;

    @Autowired
    ItemListRepository itemListRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    ListToListCommandConverter listToListCommandConverter;

    @Override
    public ItemListCommand createList(ItemListCommand itemListCommand) throws RuntimeException {
        ItemList itemList =  itemListRepository.save(listCommandToListConverter.convert(itemListCommand) );
        return listToListCommandConverter.convert(itemList);
    }

    @Override
    public List<ItemListCommand> findByUserId(Long id) throws ResourceNotFoundException {
        usersService.findById(id);

        return itemListRepository.findByUserId(id).stream().map(itemList -> {
            return listToListCommandConverter.convert(itemList);
        }).collect(Collectors.toList());

    }

    @Override
    public PageImpl<ItemListCommand> findAll(Pageable pageable) throws ResourceNotFoundException {
        Page<ItemList> list = itemListRepository.findAll(pageable);

        if(list.getContent().size() == 0){
            throw new ResourceNotFoundException("Not Found Any Item");
        }
       List<ItemListCommand> listCommandItemList = list.getContent().stream().map(item -> listToListCommandConverter.convert(item)).collect(Collectors.toList());

        return new PageImpl<ItemListCommand>(listCommandItemList, PageRequest.of(pageable.getPageNumber(),pageable.getPageSize()),list.getTotalElements());
    }

    //Eğer modelin id değerini set edersen ve save metodunu kullanırsan hibernate id si solu olduğu için otomatik update yapıyor
    @Override
    public ItemListCommand updateList(ItemListCommand itemListCommand) throws ResourceNotFoundException {
        if(!itemListRepository.findById(itemListCommand.getId()).isPresent())
            throw new ResourceNotFoundException("List Not Found -> ID : " + itemListCommand.getId());

        ItemList itemList = itemListRepository.save(listCommandToListConverter.convert(itemListCommand));
        if(itemList == null)
            throw new ResourceNotFoundException("Not Update Item List -> ID : " + itemListCommand.getId());
        return listToListCommandConverter.convert(itemList);
    }

    @Override
    public ItemListCommand findById(Long Id) throws ResourceNotFoundException {
        ItemList itemList =  itemListRepository.findById(Id).orElseThrow(() ->  new ResourceNotFoundException("Not Found Any List -> ID : " + Id ));
        return listToListCommandConverter.convert(itemList);
    }

    @Override
    public void delete(Long Id) throws ResourceNotFoundException {
        itemListRepository.findById(Id).map(itemList -> {
            itemListRepository.delete(itemList);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Not Found Any List -> ID : "+ Id));
    }
}
