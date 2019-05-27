package com.example.retail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
public class RetailApplicationTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RetailDiscountController retailDiscount;
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
     }

    @Test
    public int finalAmountTests() throws Exception {
    	
    	UserData userdata = new UserData();
    	String uri= "/retail/netAmount/";
        userdata.setUserType("employee");
        userdata.setYears(3);
        userdata.setAmount(500);
        userdata.setItem_type("clothing");
        String inputJson=super.mapToJson(userdata);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
        	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        	   
        	   int status = mvcResult.getResponse().getStatus();
        	   assertEquals(200, status);
        	   String content = mvcResult.getResponse().getContentAsString();
        	   assertEquals(content, "net_amount:332.5");
        
    }
}

