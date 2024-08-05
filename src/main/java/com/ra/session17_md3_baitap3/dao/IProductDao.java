package com.ra.session17_md3_baitap3.dao;

import com.ra.session17_md3_baitap3.model.Product;

import java.util.List;

public interface IProductDao
{
	// hiển thị là cần 1 list product để forEach và hiển thị
	List<Product> findAll();
	
	// thêm mới thì cần phải có đối tượng product
	void save(Product product);
}
