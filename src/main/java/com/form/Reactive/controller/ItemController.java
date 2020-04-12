package com.form.Reactive.controller;

import com.form.Reactive.model.Item;
import com.form.Reactive.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/getItem")
    public Item getItem()
    {
        Item item = new Item();
        item.setItemName("cpu");
        item.setPrice(1000);
        item.setQuantity(2);
        return  item;
    }
    @GetMapping("/getItemfromService")
    public Item getItemFromservice()
    {
        return itemService.retrieveItemDetails();
    }
}
