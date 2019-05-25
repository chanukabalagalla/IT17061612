package com.chanuka.repository;
import org.springframework.data.repository.CrudRepository;

import com.chanuka.model.Products;

public interface ProductRepository extends CrudRepository<Products, Long> {

}