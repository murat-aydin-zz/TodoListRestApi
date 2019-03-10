package com.example.huawei.huaweiapi.repository;

import com.example.huawei.huaweiapi.domain.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ItemListRepository extends JpaRepository<ItemList, Long> {

    Set<ItemList> findByUserId(Long id);




}
