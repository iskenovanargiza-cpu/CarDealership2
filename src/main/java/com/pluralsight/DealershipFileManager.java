package com.pluralsight;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {

    public static final String FILE_NAME = "src/main/resources/inventory.csv";

    public static Dealership getDealership() {
        Dealership dealership = null;

        try {
            FileReader file = new FileReader(FILE_NAME);
            BufferedReader bufReader = new BufferedReader(file);
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split("\\|");
                if (tokens.length > 3) {
                    dealership.addVehicle(new Vehicle(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6]), Double.parseDouble(tokens[7])));
                } else {//Dealership Name and Number
                    dealership = new Dealership(tokens[0], tokens[1], tokens[2]);
                }
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dealership;

    }
    public static void saveDealership(Dealership dealership) {

        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(FILE_NAME, false));
            bufWriter.write(String.format("%s|%s|s", dealership.getName(), dealership.getAddress(), dealership.getPhone()));
            bufWriter.newLine();

            for (Vehicle v: dealership.getAllVehicles()) {
                bufWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f", v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice()));
                bufWriter.newLine();
            }

            bufWriter.close(); //Saves file
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}