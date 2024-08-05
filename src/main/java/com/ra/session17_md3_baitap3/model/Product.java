package com.ra.session17_md3_baitap3.model;

public class Product
{
	private Integer id;
	private String name;
	private Double price;
	private Integer stock;
	private Category category;
	private Boolean status;
	
	public Product()
	{
	}
	
	public Product(Integer id, String name, Double price, Integer stock, Category category, Boolean status)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
		this.status = status;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Double getPrice()
	{
		return price;
	}
	
	public void setPrice(Double price)
	{
		this.price = price;
	}
	
	public Integer getStock()
	{
		return stock;
	}
	
	public void setStock(Integer stock)
	{
		this.stock = stock;
	}
	
	public Category getCategory()
	{
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
	public Boolean getStatus()
	{
		return status;
	}
	
	public void setStatus(Boolean status)
	{
		this.status = status;
	}
}
