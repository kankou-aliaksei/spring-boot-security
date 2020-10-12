package com.tradesystem.repository;

import com.tradesystem.domain.ProductRepository;
import com.tradesystem.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaProductRepository extends JpaRepository<ProductEntity, Long>, ProductRepository {
}
