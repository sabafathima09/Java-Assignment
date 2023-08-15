package com.furniture.service;

import java.util.List;

import com.furniture.exception.FurnitureNotFoundException;
import com.furniture.model.Furniture;

public interface IFurnitureService {

	void addFurniture(Furniture furniture);

	void removeFurniture(int furnitureId);

	void updateFurniturePrice(double price, int furnitureId);

	List<Furniture> getAllFurniture();

	List<Furniture> getFurnitureByCategory(String category) throws FurnitureNotFoundException;

	List<Furniture> getFurnitureLessThanPrice(double maxPrice)throws FurnitureNotFoundException;

	List<Furniture> getFurnitureByMaterial(String material)throws FurnitureNotFoundException;

}
