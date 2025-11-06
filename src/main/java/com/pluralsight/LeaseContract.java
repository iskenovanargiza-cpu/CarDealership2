package com.pluralsight;

public class LeaseContract extends Contract {
    private Vehicle vehicle;
    private double leaseFee;
    private double expectedEndingValue;
    private boolean isFinanced;

    public LeaseContract(String date, String customerName, String customerEmail,Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.vehicle = vehicle;
        this.leaseFee = leaseFee;
        this.expectedEndingValue = expectedEndingValue;
        this.isFinanced = isFinanced;
    }

    @Override
    public double getTotalPrice() {
        return getLeaseFee() + getExpectedEndingValue();
    }

    @Override
    public double getMonthlyPayment() {
        double annualInterest = 0.04;
        int monthTerm = 36;
        double r = annualInterest/12;
        return (getTotalPrice() * r / (1 - Math.pow(1 + r, -monthTerm)));
    }
    @Override
    public String getContractType(){
        return "LEASE";
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getLeaseFee() {
        return 0.07 * vehicle.getPrice();
    }

    public double getExpectedEndingValue() {
        return 0.5 * vehicle.getPrice();
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}
