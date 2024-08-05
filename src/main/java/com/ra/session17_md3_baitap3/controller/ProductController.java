package com.ra.session17_md3_baitap3.controller;

import com.ra.session17_md3_baitap3.dao.ICategoryDao;
import com.ra.session17_md3_baitap3.dao.IProductDao;
import com.ra.session17_md3_baitap3.dto.request.ProductRequest;
import com.ra.session17_md3_baitap3.model.Category;
import com.ra.session17_md3_baitap3.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController
{
	@Autowired
	private IProductDao productDao;
	@Autowired
	private ICategoryDao categoryDao;
	
	// /products
	@GetMapping
	public String homeProduct(Model model)
	{
		model.addAttribute("products", productDao.findAll());
		return "product/products";
	}
	
	// /products/viewAdd
	@GetMapping("/viewAdd")
	public String viewAdd(Model model)
	{
		model.addAttribute("categories", categoryDao.findAll());
		model.addAttribute("product", new Product());
		return "product/add_product";
	}
	
	// /products/add method post
	@PostMapping("/add")
	public String addProduct(@ModelAttribute Product product)
	{
//		Product product = new Product();
//		product.setName(productRequest.getName());
//		product.setPrice(productRequest.getPrice());
//		product.setStock(productRequest.getStock());
//		product.setStatus(productRequest.getStatus());
//		Category category = new Category();
//		category.setId(productRequest.getCategoryId());
//		product.setCategory(category);
		productDao.save(product);
		return "redirect:/products";
	}
	
	
}
