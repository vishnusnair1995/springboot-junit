package com.form.Reactive.controller;

import com.form.Reactive.model.Item;
import com.form.Reactive.service.ItemService;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
public class ItemControllerTests {


    private MockMvc mockMvc;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ResponseEntity<List<Item>> responseEntity;

    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
        Mockito.when(itemService.retrievefromDb()).thenReturn(responseEntity);
        Mockito.when(itemService.retrieveItemDetails()).thenReturn(new Item(1,"ups",100,5));
    }

    @Test
    public void getItemBasicTest() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItem").accept(MediaType.APPLICATION_JSON);
        MvcResult results = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(
               "{'itemName':'cpu','price':1000,'quantity':2}")).andReturn();


    }

    @Test
    public void getItemDataFromServiceTest() throws Exception
    {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemfromService").accept(MediaType.APPLICATION_JSON);
        MvcResult results = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(
                "{'itemName':'ups','price':100,'quantity':5}")).andReturn();


    }
    @Test
    public void getItemDataFromSDataBaseTest() throws Exception
    {
        List<Item> items =new ArrayList<Item>();
        Item item = new Item();
        item.setPrice(100);
        item.setQuantity(1);
        item.setItemName("hg");
        items.add(item);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemfromService").accept(MediaType.APPLICATION_JSON);
        MvcResult results = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();




    }

}
