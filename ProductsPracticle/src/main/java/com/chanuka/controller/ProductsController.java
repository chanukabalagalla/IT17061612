package com.chanuka.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chanuka.model.Products;
import com.chanuka.service.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductsController {

 private static final ProductService speciemenService = null;
@Autowired
 ProductService productService;
 

 @RequestMapping(value="/list", method=RequestMethod.GET)
 public ModelAndView list() {
  ModelAndView model = new ModelAndView("product_list");
  List<Products> productList = productService.getAllProducts();
  model.addObject("productList", productList);
  
  return model;
 }
 
 
 @RequestMapping(value="/addProduct/", method=RequestMethod.GET)
 public ModelAndView addProduct() {
  ModelAndView model = new ModelAndView();
  
  Products product = new Products();
  model.addObject("productForm", product);
  model.setViewName("product_form");
  
  return model;
 }
 
 
 @RequestMapping(value="/updateProduct/{id}", method=RequestMethod.GET)
 public ModelAndView editProduct(@PathVariable long id) {
  ModelAndView model = new ModelAndView();
  
  Products product = productService.getProductById(id);
  model.addObject("productForm", product);
  model.setViewName("product_form");
  
  return model;
 }
 
 
 @RequestMapping(value="/saveProduct", method=RequestMethod.POST)
 public ModelAndView save(@ModelAttribute("productForm") Products product) {
  productService.saveOrUpdate(product);
  
  return new ModelAndView("redirect:/product/list");
 }
 
 
 @RequestMapping(value="/deleteProduct/{id}", method=RequestMethod.GET)
 public ModelAndView delete(@PathVariable("id") long id) {
  productService.deleteProduct(id);
  
  return new ModelAndView("redirect:/product/list");
 }

 /*
 @PostMapping("/uploadImage")
 public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
	 String returnValue = "start";
	 try { 
	 speciemenService.saveImage(imageFile);
	 }
	 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
		 returnValue = "error";
	}
	 return returnValue;
 }
*/
}