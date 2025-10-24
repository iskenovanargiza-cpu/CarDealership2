package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.Dealership.*;

public class UserInterface {
//    dealership: Dealership

    public static void UserInterface() {
        System.out.println("=== Welcome to our Vehicle Store===");
        run();
    }

    public static void run() {
        while (true) {
            display();
            displaySelector();
        }
    } public static void display() {
        System.out.println("=== Options ===");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");

    }
    public static void displaySelector() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a number of your choice: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Vehicle> vehicles;

            switch (userChoice) {
                case '1':
                    getVehiclesByPriceRange(vehicles, scanner);
                    break;
                case '2':
                    getVehiclesByMakeModel();
                    break;
                case '3':
                    getVehiclesByYear();
                    break;
                case '4':
                    getVehiclesByColor();
                case '5':
                    getVehiclesByMileage();
                    break;
                case '6':
                    getVehiclesByType();
                    break;
                case '7':
                    getAllVehicles();
                    break;
                case '8':
                    addVehicle();
                    break;
                case '9':
                    removeVehicle();
                    break;
                case '99':
                    System.exit(0);
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Entered wrong number");
            }
        }



}
