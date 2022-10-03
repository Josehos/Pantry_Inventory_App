package com.kenzie.appserver.repositories;

import com.kenzie.appserver.repositories.model.ItemRecord;
import com.kenzie.appserver.service.model.Item;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface ItemRepository extends CrudRepository<ItemRecord, String> {
    // should this be an ItemRecord instead, seeing as the ItemRepository is storing ItemRecords?
    List<Item> findByLocation(String location);

}
