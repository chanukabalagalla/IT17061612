package com.chanuka.service;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chanuka.model.Products;
import com.chanuka.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
 
 @Autowired
 ProductRepository productRepository;

 @Override
 public List<Products> getAllProducts() {
  return (List<Products>) productRepository.findAll();
 }

 @Override
 public Products getProductById(long id) {
  return productRepository.findById(id).get();
 }

 @Override
 public void saveOrUpdate(Products product) {
  productRepository.save(product);
 }

 @Override
 public void deleteProduct(long id) {
  productRepository.deleteById(id);
 }

 /*
@Override
public void saveImage(MultipartFile imageFile) throws Exception {
	String folder = "/photos/";
	byte[] bytes = imageFile.getBytes();
	Path path = Paths.get(folder + imageFile.getOriginalFilename());
	Files.write(path, bytes);
}

*/

}