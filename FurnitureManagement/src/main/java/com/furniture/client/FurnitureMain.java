//package com.furniture.client;
//
//import java.util.List;
//import java.util.Scanner;
//
//import com.furniture.exception.FurnitureNotFoundException;
//import com.furniture.model.Furniture;
//import com.furniture.service.FurnitureServiceImpl;
//import com.furniture.service.IFurnitureService;
//
//public class FurnitureMain {
//
//	public static void main(String[] args) throws FurnitureNotFoundException {
//		IFurnitureService furnitureService = new FurnitureServiceImpl();
//// 		furnitureService.addFurniture(new Furniture("King Size Bed",8,"Home Furniture","Shesamwood",120000.0));
////		furnitureService.addFurniture(new Furniture("Diwan",4,"Home Furniture","Mangowood",25000.0));
////		furnitureService.addFurniture(new Furniture("Desk",5,"office Furniture","Teakwood",18000.0));
////		furnitureService.addFurniture(new Furniture("filing Cabinet",6,"office Furniture","Rosewood",18000.0));
////		furnitureService.addFurniture(new Furniture("chair",9,"office Furniture","metal and cushion",8000.0));
//
////		furnitureService.removeFurniture(2);
////		furnitureService.getAllFurniture().forEach(System.out::println);
////		System.out.println("furniture of category: ");
////		System.out.println();
//
////		furnitureService.addFurniture(new Furniture("children Bed",1,"Home Furniture","Shesamwood",150000.0));
////		furnitureService.addFurniture(new Furniture("study table",2,"Office Furniture","Mangowood",27000.0));
//
////		furnitureService.getFurnitureLessThanPrice(20000).forEach(System.out::println);
////		System.out.println();
////		furnitureService.getFurnitureByCategory("Home Furniture").forEach(System.out::println);
////		System.out.println();
////		furnitureService.getFurnitureByMaterial("Mangowood").forEach(System.out::println);
//
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter Id:");
//		int id = scanner.nextInt();
//		System.out.println("Enter Price:");
//		double price = scanner.nextDouble();
//		furnitureService.updateFurniturePrice(price, id);
//
//	}
//}