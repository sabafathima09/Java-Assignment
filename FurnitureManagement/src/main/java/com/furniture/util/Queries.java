package com.furniture.util;

public class Queries {
	public static final String CREATE_QUERY = "CREATE TABLE furniture (furnitureId INTEGER PRIMARY KEY, furnitureName VARCHAR(30), furnitureCategory VARCHAR(30), furnitureMaterial VARCHAR(30), price DOUBLE)";
	public static final String INSERTQUERY = "Insert into furniture (furnitureName,furnitureId, furnitureCategory, furnitureMaterial, price) values (?,?,?,?,?);";
	public static final String UPDATEQUERY = "update furniture set price=? where furnitureId= ? ;";
	public static final String DELETEQUERY = "delete from furniture where furnitureId=? ";
	public static final String FINDALLQUERY = "select * from furniture";
	public static final String QUERYBYCATEGORY = "select * from furniture where furnitureCategory = ? ;";
	public static final String QUERYBYMATERIAL = "select * from furniture  where furnitureMaterial  = ? ;";
	public static final String SELECT_FURNITURE_LESS_THAN_PRICE = "SELECT * FROM furniture WHERE price < ?";
}
