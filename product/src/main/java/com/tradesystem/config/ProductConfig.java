package com.tradesystem.config;

import com.tradesystem.controller.ProductRestController;
import com.tradesystem.domain.DefaultProductService;
import com.tradesystem.domain.ProductRepository;
import com.tradesystem.domain.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AuthConfig.class)
public class ProductConfig {

    private final ProductRepository productRepository;

    public ProductConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    ProductService productService() {
        return new DefaultProductService(productRepository);
    }

    @Bean
    public ProductRestController productRestController() {
        return new ProductRestController(productService());
    }
}
