package com.form.Reactive.service;

import com.form.Reactive.controller.ItemController;
import com.form.Reactive.model.Item;
import com.form.Reactive.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ItemServiceTests {

    private MockMvc mockMvc;

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ResponseEntity<List<Item>> responseEntity;

    @Before
    public void setUp()
    {
        Item item =  new Item();
        item.setItemName("h");
        item.setQuantity(45);
        item.setPrice(45);
        List<Item> items = new ArrayList<>();
        items.add(item);
        mockMvc = MockMvcBuilders.standaloneSetup(itemService).build();
        Mockito.when(itemRepository.findAll()).thenReturn(items);
    }

    @Test
    public void testDataReturnedFromDb()
    {

       responseEntity = itemService.retrievefromDb();
       assertEquals( responseEntity.getBody().get(0).getPrice(),45);

    }

}
