package com.furniture.dao;

import java.util.List;

import com.furniture.model.Furniture;

public interface IFurnitureDao {
	void addFurniture(Furniture furniture);

	void removeFurniture(int furnitureId);

	void updateFurniturePrice(double price, int furnitureId); 

	List<Furniture> findAllFurniture();

	List<Furniture> findFurnitureByCategory(String category);

	List<Furniture> findFurnitureLessThanPrice(double maxPrice);

	List<Furniture> findFurnitureByMaterial(String material);
 
    
    

    
}
