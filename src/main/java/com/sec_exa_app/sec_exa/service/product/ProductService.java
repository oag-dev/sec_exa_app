package com.sec_exa_app.sec_exa.service.product;

import com.sec_exa_app.sec_exa.entity.product.ProductEntity;
import com.sec_exa_app.sec_exa.service.base.BaseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public interface ProductService extends BaseService<ProductEntity, ProductEntity, Integer> {
    default PageRequest createPageRequest(Integer page, Integer size, String sortBy) {
        if (!sortBy.equals("name") && sortBy.equals("id")) {

        } else if (sortBy.equals("name") && !sortBy.equals("id")) {

        } else {
            sortBy = "name";
        }
        PageRequest of1 = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return of1;
    }
}
