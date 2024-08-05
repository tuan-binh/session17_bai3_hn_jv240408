package com.ra.session17_md3_baitap3.dao;

import com.ra.session17_md3_baitap3.model.Category;

import java.util.List;

public interface ICategoryDao
{
	List<Category> findAll();
	
	Category findById(Integer id);
}
