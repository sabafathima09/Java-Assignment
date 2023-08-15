package com.furniture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import com.furniture.exception.FurnitureNotFoundException;
import com.furniture.model.Furniture;
import com.furniture.util.DbConnection;
import com.furniture.util.Queries;

public class FurnitureDaoImpl implements IFurnitureDao {

	private static final String Price = null;

	@Override
	public void addFurniture(Furniture furniture) {
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);
			statement.setString(1, furniture.getFurnitureName());
			statement.setDouble(5, furniture.getFurniturePrice());
			statement.setString(4, furniture.getFurnitureMaterial());
			statement.setInt(2, furniture.getFurnitureId());
			statement.setString(3, furniture.getFurnitureCategory());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void removeFurniture(int furnitureId) {
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, furnitureId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateFurniturePrice(double price, int furnitureId) {
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setInt(2, furnitureId);
			statement.setDouble(1, price);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public List<Furniture> findAllFurniture() {
		List<Furniture> furniture = new ArrayList<Furniture>();
		try (Connection connection = DbConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(Queries.FINDALLQUERY);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Furniture furnitures = new Furniture();
				String furnitureName = resultSet.getString("furnitureName");
				int furnitureId = resultSet.getInt("furnitureId");
				String furnitureCategory = resultSet.getString("furnitureCategory");
				String furnitureMaterial = resultSet.getString("furnitureMaterial");
				double price = resultSet.getDouble("price");
				furnitures.setFurnitureName(furnitureName);
				furnitures.setFurnitureId(furnitureId);
				furnitures.setFurnitureMaterial(furnitureMaterial);
				furnitures.setFurnitureCategory(furnitureCategory);
				furnitures.setFurniturePrice(price);
				furniture.add(furnitures);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return furniture;
	}

	@Override
	public List<Furniture> findFurnitureByCategory(String furnitureCategory) {
		List<Furniture> furnitures = new ArrayList<Furniture>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYCATEGORY);) {
			statement.setString(1, furnitureCategory);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String furnitureName = result.getString("furnitureName");
//				String furniturecategory = result.getString("furnitureCategory"); 
				String furnitureMaterial = result.getString("furniturematerial");
				double price = result.getDouble("price");
				int furnitureId = result.getInt("furnitureId");
				furnitures.add(new Furniture(furnitureName, furnitureId, furnitureCategory,furnitureMaterial,price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return furnitures;
	}

	@Override
	public List<Furniture> findFurnitureLessThanPrice(double maxPrice) {
		List<Furniture> furnitures = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FURNITURE_LESS_THAN_PRICE)) {
			statement.setDouble(1, maxPrice);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					String furnitureName = resultSet.getString("furnitureName");
					String furnitureCategory = resultSet.getString("furnitureCategory");
					String furnitureMaterial = resultSet.getString("furniturematerial");
					double price = resultSet.getDouble("price");
					int furnitureId = resultSet.getInt("furnitureId");
					furnitures.add(new Furniture(furnitureName, furnitureId, furnitureCategory,furnitureMaterial,price));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return furnitures;
	}

	@Override
	public List<Furniture> findFurnitureByMaterial(String furnitureMaterial) {
		List<Furniture> furnitures = new ArrayList<Furniture>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYMATERIAL);) {
			statement.setString(1, furnitureMaterial);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String furnitureName = resultSet.getString("furnitureName");
				String furnitureCategory = resultSet.getString("furnitureCategory"); 
//				String furnitureMaterial = result.getString("furniturematerial");
				double price = resultSet.getDouble("price");
				int furnitureId = resultSet.getInt("furnitureId");
				furnitures.add(new Furniture(furnitureName, furnitureId, furnitureCategory,furnitureMaterial,price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return furnitures;
	}

	private Furniture createFurnitureFromResultSet(ResultSet resultSet) throws SQLException {
		int furnitureId = resultSet.getInt("furnitureId");
		String furnitureName = resultSet.getString("furnitureName");
		String category = resultSet.getString("furnitureCategory");
		String material = resultSet.getString("furnitureMaterial");
		double price = resultSet.getDouble("price");
		return new Furniture(furnitureName, furnitureId, category, material, price);
	}

}
