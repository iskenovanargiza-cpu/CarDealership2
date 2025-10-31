package com.pluralsight;
import java.util.ArrayList;
import java.util.List;


public class Dealership {
    private String name,address,phone;
    private ArrayList <Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<Vehicle>();

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;

    }

    public List<Vehicle> getVehiclesByPriceRange(double startRange, double endRange) {
        ArrayList<Vehicle> filtered = new ArrayList<Vehicle>();
        for (Vehicle v : inventory) {
            if (startRange >= v.getPrice() && endRange <= v.getPrice()) {
                filtered.add(v);
            }
        } return filtered;

    }
        public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
            ArrayList<Vehicle> filtered = new ArrayList<Vehicle>();
        for (Vehicle v : inventory) {
            if (v.getMake().toLowerCase().contains(make.toLowerCase()) && (v.getModel().toLowerCase().contains(model.toLowerCase()))) {
                filtered.add(v);
            }
        } return filtered;

    }

    public List<Vehicle>  getVehiclesByYear(int startRange, int endRange) {
        ArrayList<Vehicle>filtered = new ArrayList<>();
        for (Vehicle v :  inventory) {
            if (startRange < v.getYear() && endRange > v.getYear()) {
                filtered.add(v);
            }
        } return filtered;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle>filtered = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) {
                filtered.add(v);
            }
        } return filtered;
    }

    public List<Vehicle> getVehiclesByMileage(int startRange, int endRange) {
        ArrayList<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (startRange > v.getOdometer() && endRange < v.getOdometer()) {
                filtered.add(v);
            }
        } return filtered;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equalsIgnoreCase(type)) {
                filtered.add(v);
            }
        } return filtered;
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public Vehicle getVehicleByVin(int vin) {
        Vehicle filtered = null;
        for (Vehicle v: inventory) {
            if (v.getVin() == vin) {
                filtered = v;
            }
        }
        return filtered;
    }

    public void addVehicle(Vehicle v) {
        this.inventory.add(v);
    }

    public void removeVehicle(Vehicle v) {
        this.inventory.remove(v);
    }
}
