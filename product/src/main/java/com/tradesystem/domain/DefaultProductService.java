package com.tradesystem.domain;

import com.tradesystem.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id).map(this::convertToProduct);
    }

    @Override
    public Product save(Product product) {
        return convertToProduct(productRepository.save(convertToProductEntity(product)));
    }

    private ProductEntity convertToProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }

    private Product convertToProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .build();
    }
}
