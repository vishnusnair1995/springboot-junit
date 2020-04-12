package com.form.Reactive.service;

import com.form.Reactive.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    public Item retrieveItemDetails()
    {
        return new Item("ups",100,5);
    }
}
