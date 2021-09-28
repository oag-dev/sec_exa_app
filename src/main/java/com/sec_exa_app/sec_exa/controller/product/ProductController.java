package com.sec_exa_app.sec_exa.controller.product;

import com.sec_exa_app.model.response.ApiResponse;
import com.sec_exa_app.sec_exa.entity.product.ProductEntity;
import com.sec_exa_app.sec_exa.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity addEntity(@RequestBody @Valid ProductEntity productEntity) {
        return ResponseEntity.status(201).body(productService.create(productEntity));
    }

    @GetMapping
    public ResponseEntity getEntiyPageBySort(@RequestParam(defaultValue = "0", name = "page") Integer page,
                                             @RequestParam(defaultValue = "10", name = "size") Integer size,
                                             @RequestParam(defaultValue = "id", name = "sortBy") String sortBy) {

        return ResponseEntity.ok(productService.getEntiyPageBySort(page, size, sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity getEntityById(@PathVariable Integer id) {
        Optional<ProductEntity> optional = productService.getEntityById(id);
        return ResponseEntity.status(optional.isEmpty() ? 404 : 200).body(optional.isEmpty() ? new ApiResponse("Id not found", false) : optional.get());
    }

    @PutMapping("{id}")
    public ResponseEntity updateById(@PathVariable Integer id, @RequestBody @Valid ProductEntity productEntity) {
        ApiResponse apiResponse = productService.updateById(id, productEntity);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 404).body(apiResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        ApiResponse apiResponse = productService.deleteById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 204 : 404).body(apiResponse);
    }
}
