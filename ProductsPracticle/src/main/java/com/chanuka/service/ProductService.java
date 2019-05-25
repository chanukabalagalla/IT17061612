package com.chanuka.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.chanuka.model.*;

public interface ProductService {

 public List<Products> getAllProducts();
 
 public Products getProductById(long id);
 
 public void saveOrUpdate(Products product);
 
 public void deleteProduct(long id);
 

// void saveImage(MultipartFile imageFile) throws Exception;
}