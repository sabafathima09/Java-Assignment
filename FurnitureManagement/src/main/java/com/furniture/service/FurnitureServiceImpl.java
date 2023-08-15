package com.furniture.service;

import java.util.List;
import java.util.stream.Collectors;

import com.furniture.dao.FurnitureDaoImpl;
import com.furniture.dao.IFurnitureDao;
import com.furniture.exception.FurnitureNotFoundException;
import com.furniture.model.Furniture;

public class FurnitureServiceImpl  implements IFurnitureService{
IFurnitureDao furnitureDao = new FurnitureDaoImpl();
	@Override
	public void addFurniture(Furniture furniture) {
		furnitureDao.addFurniture(furniture);
		System.out.println("furniture successfully added");
	}

	@Override
	public void removeFurniture(int furnitureId) {
		furnitureDao.removeFurniture(furnitureId);
		System.out.println("furniture removed" + furnitureId);
	}

	@Override
	public void updateFurniturePrice(double price, int furnitureId) {
		furnitureDao.updateFurniturePrice(price, furnitureId);
		System.out.println("furniture updated of " + furnitureId + " "+ price );
	}

	@Override
	public List<Furniture> getAllFurniture() {
		List<Furniture> furniturelist = furnitureDao.findAllFurniture();
		return furniturelist;
	}

	@Override
	public List<Furniture> getFurnitureByCategory(String category) {
		return furnitureDao.findFurnitureByCategory(category).stream().toList();
	}
	
	@Override
	public List<Furniture> getFurnitureLessThanPrice(double maxPrice) {
		  return furnitureDao.findFurnitureLessThanPrice(maxPrice).stream().toList();
	}

	@Override
	public List<Furniture> getFurnitureByMaterial(String material) {
		return furnitureDao.findFurnitureByMaterial(material).stream().toList();
	}
}