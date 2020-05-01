package com.form.Reactive.service;

import com.form.Reactive.model.Item;
import com.form.Reactive.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item retrieveItemDetails()
    {
        return new Item(1,"ups",100,5);
    }


    public ResponseEntity<List<Item>> retrievefromDb()
    {
        return ResponseEntity.ok().body(itemRepository.findAll());
    }
}
