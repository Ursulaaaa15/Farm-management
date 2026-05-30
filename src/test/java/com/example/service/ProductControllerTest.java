package com.example.service;

import com.example.service.controller.ProductController;
import com.example.service.model.Product;
import com.example.service.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetAllProducts() throws Exception {
        Product product1 = new Product();
        product1.setId(10L);
        product1.setName("Голубика");
        product1.setUnitOfMeasurement("кг");

        Product product2 = new Product();
        product2.setId(11L);
        product2.setName("Сок яблочный");
        product2.setUnitOfMeasurement("литры");

        Mockito.when(productService.getAllProducts()).thenReturn(Arrays.asList(product1, product2));

        mockMvc.perform(MockMvcRequestBuilders.get("/products/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':10,'name':'Голубика','unitOfMeasurement':'кг'}," +
                        "{'id':11,'name':'Сок яблочный','unitOfMeasurement':'литры'}]"));
    }
}
