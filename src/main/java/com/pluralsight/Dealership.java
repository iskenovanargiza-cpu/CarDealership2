package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    static Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private String phone;
    private ArrayList <Vehicle> vehicles = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

    }
    public static void getVehiclesByPriceRange(ArrayList<Vehicle> vehicles, double startRange, double endRange) {
        for (Vehicle v : vehicles) {
            if (startRange <= v.getPrice() && endRange >= v.getPrice()) {
                System.out.println(v);}

}
    } public static void getVehiclesByMakeModel(ArrayList<Vehicle> vehicles, String make, String model) {
// MAKE AND MODEL?
        for (Vehicle v : vehicles) {
            if (v.getMake().toLowerCase().contains(make.toLowerCase()) && (v.getModel().toLowerCase().contains(model.toLowerCase()))) {
                System.out.println(v);
            }
        }
    }

    public static void getVehiclesByYear(ArrayList<Vehicle> vehicles, int startRange, int endRange) {
        for (Vehicle v : vehicles) {
            if (startRange <= v.getYear() && endRange >= v.getYear()) {
                System.out.println(v);
            }
        }
    }

    public static void getVehiclesByColor(ArrayList<Vehicle> vehicles, String color) {
        for (Vehicle v : vehicles) {
            if (v.getColor().equalsIgnoreCase(color)) {
                System.out.println(v);
            }
        }
    }

    public static void getVehiclesByMileage(ArrayList<Vehicle> vehicles, double startRange, double endRange) {
        for (Vehicle v : vehicles) {
            if (startRange <= v.getOdometer() && endRange >= v.getOdometer()) {
                System.out.println(v);
//                MILEAGE ODOMETER WHY IS INT?


            }
        }
    }

    public static void getVehiclesByType(ArrayList<Vehicle> vehicles, String type) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleType().equalsIgnoreCase(type)) {
                System.out.println(v);}
        }
    }

    public static void getAllVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);}
    }
    public static void addVehicle() {
        System.out.println("--Welcome to the Add Vehicle Screen--\n");

        System.out.print("Enter the Vehicle vin: ");
        int vehicleVin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the Vehicle year: ");
        int vehicleYear = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the Make: ");
        String vehicleMake = scanner.nextLine();

        System.out.print("Enter the Model: ");
        String vehicleModel = scanner.nextLine();

        System.out.print("Enter the Type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Enter the Color: ");
        String vehicleColor = scanner.nextLine();

        System.out.print("Enter the Odometer Reading: ");
        int vehicleOdometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the Price: ");
        double vehiclePrice = scanner.nextDouble();
        scanner.nextLine();


        Vehicle newVehicle = new Vehicle(vehicleVin,vehicleYear,vehicleMake,vehicleModel,vehicleType,vehicleColor,vehicleOdometer,vehiclePrice);
        vehicles.add(newVehicle);

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv", true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.newLine();
            bufWriter.write(newVehicle.getVin() + "|" + newVehicle.getYear() + "|" + newVehicle.getMake() + "|" + newVehicle.getModel() + "|" + newVehicle.getVehicleType() + "|" + newVehicle.getColor() + "|" + newVehicle.getOdometer() + "|" + newVehicle.getPrice());
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());

            }
    }

    public void removeVehicle(ArrayList<Vehicle> vehicles, Scanner scanner) {
        System.out.println("--Please enter at least one criteria or skip by enter '0'--\n");
        System.out.print("Enter the Vehicle vin: ");
        int vehicleVin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the Vehicle year: ");
        int vehicleYear = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the Make: ");
        String vehicleMake = scanner.nextLine();

        System.out.print("Enter the Model: ");
        String vehicleModel = scanner.nextLine();

        System.out.print("Enter the Type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Enter the Color: ");
        String vehicleColor = scanner.nextLine();

        System.out.print("Enter the Odometer Reading: ");
        int vehicleOdometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the Price: ");
        double vehiclePrice = scanner.nextDouble();
        scanner.nextLine();

        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);
            if (vehicleVin !=0 && vehicleVin== v.getVin()) {
                if (vehicleYear == v.getYear()) {
                    if (vehicleMake == v.getMake()) {
                        if (vehicleModel == v.getModel()) {
                            if (vehicleType) == v.getVehicleType()
                        }
                    }
                }
            }

    } vehicles.remove(i);
}
