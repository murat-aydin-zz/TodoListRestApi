package com.example.huawei.huaweiapi.repository;

import com.example.huawei.huaweiapi.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemByItemList_Id(Long id);
    Optional<Item> findItemByIdAndItemListId(Long id,Long itemListID);
}