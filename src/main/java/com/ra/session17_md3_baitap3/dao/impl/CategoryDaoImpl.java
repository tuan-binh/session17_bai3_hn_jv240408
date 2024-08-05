package com.ra.session17_md3_baitap3.dao.impl;

import com.ra.session17_md3_baitap3.dao.ICategoryDao;
import com.ra.session17_md3_baitap3.model.Category;
import com.ra.session17_md3_baitap3.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements ICategoryDao
{
	@Override
	public List<Category> findAll()
	{
		Connection con = ConnectionDB.openConnection();
		List<Category> categories = new ArrayList<>();
		try
		{
			PreparedStatement statement = con.prepareStatement("select * from category");
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Boolean status = rs.getBoolean("status");
				Category category = new Category(id, name, status);
				categories.add(category);
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
		return categories;
	}
	
	@Override
	public Category findById(Integer id)
	{
		Connection con = ConnectionDB.openConnection();
		Category category = null;
		try
		{
			PreparedStatement statement = con.prepareStatement("select * from category where id = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				String name = rs.getString("name");
				Boolean status = rs.getBoolean("status");
				category = new Category(id, name, status);
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
		return category;
	}
}
