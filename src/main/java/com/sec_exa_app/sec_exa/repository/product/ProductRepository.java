package com.sec_exa_app.sec_exa.repository.product;

import com.sec_exa_app.sec_exa.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
