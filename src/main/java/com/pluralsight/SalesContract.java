package com.pluralsight;

public class SalesContract extends Contract {
    private boolean isFinanced;


    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold,boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;

    }

    public double getSalesTaxAmount() {
        return this.vehicleSold.getPrice() * 0.05;
    }

    public double getRecordingFee() {
        return 100.00;
    }

    public double getProcessingFee() {
        if (this.vehicleSold.getPrice() < 10000) {
            return 295.00;
        }
        return 495.00;
    }

    @Override
    public double getTotalPrice() {
        return this.vehicleSold.getPrice() + getSalesTaxAmount() + getRecordingFee() + getProcessingFee();
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
        return this.vehicleSold;
    }

    public boolean isFinanced() {
        return this.isFinanced;
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
        this.vehicleSold = vehicle;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}

