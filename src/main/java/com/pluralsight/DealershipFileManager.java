package com.pluralsight;
import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public static getDealership(ArrayList<Vehicle> vehicles) {

        try {
            FileReader file = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(file);

            String input;
            bufReader.readLine();

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split("\\|");
                Integer vin = Integer.parseInt(tokens[0]);
                Integer year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String type = tokens[4];
                String color = tokens[5];
                Integer odometer = Integer.parseInt(tokens[6]);
                Double price = Double.parseDouble(tokens[7]);

                vehicles.add(new Vehicle(vin, year, make, model, type, color, odometer, price));
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return vehicles;

    }
    public static void saveDealership(ArrayList<Vehicle> vehicles){
        Dealership.addVehicle();

}}
