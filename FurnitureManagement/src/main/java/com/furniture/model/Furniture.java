package com.furniture.model;

import java.util.List;

public class Furniture {
	private String furnitureName;
	private String furnitureMaterial;
	private String furnitureCategory;
	private Integer furnitureId;
	private double furniturePrice;

	public Furniture() {
		super();
	}

	public Furniture(String furnitureName, Integer furnitureId, String furnitureCategory, String furnitureMaterial,
			double furniturePrice) {
		super();
		this.furnitureName = furnitureName;
		this.furnitureMaterial = furnitureMaterial;
		this.furnitureCategory = furnitureCategory;
		this.furnitureId = furnitureId;
		this.furniturePrice = furniturePrice;
	}

	public String getFurnitureName() {
		return furnitureName;
	}

	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}

	public String getFurnitureMaterial() {
		return furnitureMaterial;
	}

	public void setFurnitureMaterial(String material) {
		this.furnitureMaterial = material;
	}

	public String getFurnitureCategory() {
		return furnitureCategory;
	}

	public void setFurnitureCategory(String furnitureCategory) {
		this.furnitureCategory = furnitureCategory;
	}

	public Integer getFurnitureId() {
		return furnitureId;
	}

	public void setFurnitureId(Integer furnitureId) {
		this.furnitureId = furnitureId;
	}

	public double getFurniturePrice() {
		return furniturePrice;
	}

	public void setFurniturePrice(double furniturePrice) {
		this.furniturePrice = furniturePrice;
	}

	@Override
	public String toString() {
		return "Furniture [furnitureName=" + furnitureName + ", furnitureMaterial=" + furnitureMaterial
				+ ", furnitureCategory=" + furnitureCategory + ", furnitureId=" + furnitureId + ", furniturePrice="
				+ furniturePrice + "]";
	}


}
