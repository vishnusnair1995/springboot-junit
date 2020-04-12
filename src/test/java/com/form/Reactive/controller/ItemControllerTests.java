package com.form.Reactive.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.Assert.assertEquals;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@RunWith(SpringRunner.class)
public class ItemControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getItemBasicTest() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItem").accept(MediaType.APPLICATION_JSON);
        MvcResult results = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(
               "{'itemName':'cpu','price':1000,'quantity':2}")).andReturn();


    }
}
