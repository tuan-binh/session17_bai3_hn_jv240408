package com.ra.session17_md3_baitap3.dao.impl;

import com.ra.session17_md3_baitap3.dao.ICategoryDao;
import com.ra.session17_md3_baitap3.dao.IProductDao;
import com.ra.session17_md3_baitap3.model.Category;
import com.ra.session17_md3_baitap3.model.Product;
import com.ra.session17_md3_baitap3.utils.ConnectionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements IProductDao
{
	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	public List<Product> findAll()
	{
		Connection con = ConnectionDB.openConnection();
		List<Product> products = new ArrayList<>();
		try
		{
			PreparedStatement statement = con.prepareStatement("select * from product");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				Integer stock = rs.getInt("stock");
				Category category = categoryDao.findById(rs.getInt("category_id"));
				Boolean status = rs.getBoolean("status");
				Product product = new Product(id, name, price, stock, category, status);
				products.add(product);
			}
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			ConnectionDB.closeConnection(con);
		}
		return products;
	}
	
	@Override
	public void save(Product product)
	{
		Connection con = ConnectionDB.openConnection();
		try
		{
			PreparedStatement statement = con.prepareStatement("insert into product (name,price,stock,category_id,status) values (?,?,?,?,?)");
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setInt(3, product.getStock());
			statement.setInt(4, product.getCategory().getId());
			statement.setBoolean(5, product.getStatus());
			statement.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			ConnectionDB.closeConnection(con);
		}
	}
}
