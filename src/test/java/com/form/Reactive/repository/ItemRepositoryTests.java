package com.form.Reactive.repository;

import com.form.Reactive.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testAll()
    {
        List<Item> itemList = itemRepository.findAll();
        assertEquals(itemList.size(),1);
    }
}
