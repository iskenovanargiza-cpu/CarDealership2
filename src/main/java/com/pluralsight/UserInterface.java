package com.pluralsight;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }


    public void display() {
        init();

        do {
            homeMenuScreen();

            System.out.println("Choose a number of your choice: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 10 -> processSellLeaseVehicleRequest();
                case 99 -> System.exit(0);
                default -> {
                    System.out.println("Invalid option entered, please try again...");
                }
            }
        } while (true);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
        System.out.println();
    }

    public void processGetByPriceRequest() {
        System.out.print("Please enter the max price: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the min price: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByPriceRange(min, max));
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Please enter the make: ");
        String make = scanner.nextLine();

        System.out.print("Please enter the model: ");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest() {
        System.out.print("Please enter the max year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the min year: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest() {
        System.out.print("Please enter the color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {
        System.out.print("Please enter the max mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the min mileage: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Please enter the type: ");
        String type = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        System.out.print("Please enter the vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the make: ");
        String make = scanner.nextLine();

        System.out.print("Please enter the model: ");
        String model = scanner.nextLine();

        System.out.print("Please enter the type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Please enter the color: ");
        String color = scanner.nextLine();

        System.out.print("Please enter the price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
        DealershipFileManager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Please enter the vin of the car you want to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        dealership.removeVehicle(dealership.getVehicleByVin(vin));
        DealershipFileManager.saveDealership(dealership);
    }

    public void processSellLeaseVehicleRequest() {
        // 1. Get Customer Information
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Enter date of transaction (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter the VIN of the vehicle: ");
        int vin = scanner.nextInt();
        Vehicle vehicleByVin = dealership.getVehicleByVin(vin);

        if (vehicleByVin == null) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        } else {
            displayVehicles(dealership.getAllVehicles());
        }

        //2. Asking user if sale or lease
        System.out.println("Choose the number for transaction:");
        System.out.println("1 - Sell a vehicle");
        System.out.println("2 - Lease a vehicle");

        int userChoice = scanner.nextInt();
        scanner.nextLine();

        Contract contract = null;


        switch (userChoice) {
            case 1 -> sellVehicle(date, customerName, customerEmail, vehicleByVin);
            case 2 -> leaseVehicle(date, customerName, customerEmail, vehicleByVin);
            case 3 -> System.exit(0);
            default -> {
                System.out.println("Invalid choice.");
            }
        }
    }

    public void sellVehicle(String date, String customerName, String customerEmail, Vehicle vehicle) {
        System.out.println("Will the customer finance? Enter 'Y' for yes and 'N' for no.");
        String userInput = scanner.nextLine();
        boolean isFinanced = userInput.equalsIgnoreCase("Y");
        SalesContract sc = new SalesContract(date, customerName, customerEmail, vehicle, isFinanced);
        ContractFileManager.saveContract(sc);
        dealership.removeVehicle(vehicle);
        System.out.println("Sell contract has been created successfully.");
    }

    public void leaseVehicle(String date, String customerName, String customerEmail, Vehicle vehicle) {
        int year = LocalDate.now().getYear();
        int vehicleAge = year - vehicle.getYear();
        if (vehicleAge > 3) {
            System.out.println("This vehicle is too old to lease. You mau choose a different vehicle.");
            return;
        } else {
            LeaseContract lc = new LeaseContract(date, customerName, customerEmail, vehicle);
            ContractFileManager.saveContract(lc);
            dealership.removeVehicle(vehicle);
            System.out.println("Lease contract has been created successfully.");

        }
    }

    public static void homeMenuScreen() {
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
        System.out.println("10 - Sell / Lease a vehicle");
        System.out.println("99 - Quit");

    }
}


