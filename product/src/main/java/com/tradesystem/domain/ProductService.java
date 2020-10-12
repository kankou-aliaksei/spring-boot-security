package com.tradesystem.domain;

import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(long id);
    Product save(Product product);
}
