package com.example.mysql;

import com.example.mysql.product.data.ProductModel;
import com.example.mysql.product.repo.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("productTransactionManager")
    public void create_check_product() {
        ProductModel product = new ProductModel("228781", "Running Shoes", 20.0);
        product = productRepository.save(product);

        assertNotNull(productRepository.findById(product.getId()));
    }
}
