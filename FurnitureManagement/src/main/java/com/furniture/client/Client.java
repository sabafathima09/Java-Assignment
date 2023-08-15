package com.furniture.client;

import java.util.List;
import java.util.Scanner;

import com.furniture.exception.FurnitureNotFoundException;
import com.furniture.model.Furniture;
import com.furniture.service.FurnitureServiceImpl;
import com.furniture.service.IFurnitureService;

public class Client {
	private static Furniture[] furniture;

	public static void main(String[] args) throws FurnitureNotFoundException {

		IFurnitureService furnitureService = new FurnitureServiceImpl();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Furniture Management:");
			System.out.println("1. Display all furniture");
			System.out.println("2. Search furniture by category");
			System.out.println("3. Search furniture less than price");
			System.out.println("4. Search furniture by Material");
			System.out.println("5. Add Furniture");
			System.out.println("6. Delete Furniture");
			System.out.println("7. Update Furniture");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			String category;
			String material;
			switch (choice) {
			case 1:
				List<Furniture> allFurniture = furnitureService.getAllFurniture();
				displayFurniture(allFurniture);
				break;
			case 2:
				System.out.print("Enter from Furniture category: ");
				category = scanner.nextLine();
				try {
					furnitureService.getFurnitureByCategory(category).forEach(System.out::println);
				} catch (FurnitureNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;
			case 3:
				System.out.print("Enter maximum price: ");
				double maxPrice = scanner.nextDouble();
				List<Furniture> furniturePrice = furnitureService.getFurnitureLessThanPrice(maxPrice);
				displayFurniture(furniturePrice);
				break;
			case 4:
				System.out.print("Enter from Furniture Material: ");
				material = scanner.nextLine();
				try {
					furnitureService.getFurnitureByMaterial(material).forEach(System.out::println);
				} catch (FurnitureNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				break;	
			case 5:
				System.out.println("Enter the furniture Details");
				System.out.print("furnitureName: ");
			    String furnitureName = scanner.next();
				System.out.print("furnitureId: ");
				Integer furnitureId = scanner.nextInt();
				System.out.print("furnitureCategory: ");
				String furnitureCategory = scanner.next();
				scanner.nextLine();
				System.out.print("furnitureMaterial: ");
				String furnitureMaterial= scanner.next();
				System.out.print("Price: ");
				double maxprice = scanner.nextDouble();
				furnitureService.addFurniture(new Furniture(furnitureName,furnitureId,furnitureCategory,furnitureMaterial,maxprice));
				System.out.println();
				break;
			case 6:
				System.out.print("Enter FurnitureID: ");
				furnitureId = scanner.nextInt();
				furnitureService.removeFurniture(furnitureId);
				System.out.println();
				break;
			case 7:
				System.out.print("Enter FurnitureID: ");
				furnitureId = scanner.nextInt();
				System.out.print("Enter new price: ");
				maxPrice = scanner.nextDouble();
				furnitureService.updateFurniturePrice(maxPrice,furnitureId);
				System.out.println();
				break;
			case 8:
				System.out.println("Exited");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
				System.out.println();
				break;
			}
		}
	}

	private static void displayFurniture(List<Furniture> allFurniture) {
		for (Furniture furniture : allFurniture) {
			System.out.println(furniture);
		}
	}
}