package com.sec_exa_app.sec_exa.service.product;

import com.sec_exa_app.model.response.ApiResponse;
import com.sec_exa_app.sec_exa.entity.product.ProductEntity;
import com.sec_exa_app.sec_exa.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ApiResponse create(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return new ApiResponse("Mahsulot mufoqiyatli qoshildi", true);
    }

    @Override
    public Page<ProductEntity> getEntiyPageBySort(Integer page,
                                                  Integer size,
                                                  String sortBy) {
        return productRepository.findAll(createPageRequest(page, size, sortBy));
    }

    @Override
    public Optional<ProductEntity> getEntityById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public ApiResponse updateById(Integer id, ProductEntity productEntity) {
        Optional<ProductEntity> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("Id not  found", false);
        } else {
            ProductEntity productEntity1 = byId.get();
            productEntity1.setName(productEntity.getName());
            productRepository.save(productEntity1);
            return new ApiResponse("Mahsulot tahrirlandi", true);
        }
    }

    @Override
    public ApiResponse deleteById(Integer id) {
        Optional<ProductEntity> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("Id not  found", false);
        } else {
            productRepository.deleteById(id);
            return new ApiResponse("Mahsulot o'chirildi", true);
        }
    }
}
