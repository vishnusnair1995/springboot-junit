package com.form.Reactive.controller;

import com.form.Reactive.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/getItem")
    public Item getItem()
    {
        Item item = new Item();
        item.setItemName("cpu");
        item.setPrice(1000);
        item.setQuantity(2);
        return  item;
    }
}
