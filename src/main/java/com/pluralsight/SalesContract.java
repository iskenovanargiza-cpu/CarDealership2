package com.pluralsight;

public class SalesContract extends Contract {
    private String date, customerName, customerEmail;
    private Vehicle vehicle;
    private boolean isFinanced;
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, String date1, String customerName1, String customerEmail1, Vehicle vehicle, boolean isFinanced, double salesTaxAmount, double recordingFee, double processingFee) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.date = date1;
        this.customerName = customerName1;
        this.customerEmail = customerEmail1;
        this.vehicle = vehicle;
        this.isFinanced = isFinanced;
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
    }

    public double getSalesTaxAmount() {
        return vehicle.getPrice() * 0.05;
    }

    public double getRecordingFee() {
        return 100.00;
    }

    public double getProcessingFee() {
        if (vehicle.getPrice() < 10000) {
            return 295.00;
        }
        return 495.00;
    }

    @Override
    public double getTotalPrice() {
        return salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0;
        }
        double interestRate;
        int loanMonths;

        if (getTotalPrice() >= 10.000) {
            interestRate = 0.0425;
            loanMonths = 48;
        } else {
            interestRate = 0.0525;
            loanMonths = 24;
        }
        double r = interestRate / 12;
        return (getTotalPrice() * r / (1 - Math.pow(1 + r, -loanMonths)));

    }
    @Override
    public String getContractType(){
        return "SALE";
    }


    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}

