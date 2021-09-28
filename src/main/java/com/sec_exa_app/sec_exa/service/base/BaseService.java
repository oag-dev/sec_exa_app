package com.sec_exa_app.sec_exa.service.base;


import org.springframework.data.domain.Page;
import com.sec_exa_app.model.response.ApiResponse;

import java.util.Optional;

//Bu interface Hamma entity uchun hizmat qiluvchi service <Kiruvchi, Chiquvchi> bunda 1 chi Http body da kelga Object, Http body da ketadigan Object
public interface BaseService<Kiruvchi, Chiquvchi, ID> {

    //Create Entity
    ApiResponse create(Kiruvchi kiruvchi);

    //Get Page<Entity>
    Page<Chiquvchi> getEntiyPageBySort(Integer page, Integer size, String sortBy);

    //Get by id Optional<Entity> Sababi Http Status kodini tog'ri jo'natish uchun
    Optional<Chiquvchi> getEntityById(ID id);

    //Update Entity by id
    ApiResponse updateById(ID id, Kiruvchi kiruvchi);

    //Delete Entity by id
    ApiResponse deleteById(Integer id);
}
