package com.example.service;

import com.example.service.model.Product;
import com.example.service.repository.ProductRepository;
import com.example.service.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Клубника");
        product1.setUnitOfMeasurement("кг");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Сок");
        product2.setUnitOfMeasurement("литры");

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = productService.getAllProducts();
        assertThat(products).hasSize(2);
        assertThat(products.get(0).getName()).isEqualTo("Клубника");
        assertThat(products.get(1).getName()).isEqualTo("Сок");
    }
}
