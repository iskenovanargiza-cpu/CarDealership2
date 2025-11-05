package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public static final String FILE_NAME = "src/main/resources/contracts.csv";

    public static void saveContract(Contract contract) {


        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(FILE_NAME, true));
            Vehicle vehicle = contract.getVehicleSold();
            bufWriter.write(String.format("%s|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f",
                    contract.getContractType(), contract.getDate(), contract.getCustomerName(),contract.getCustomerEmail(),vehicle.getVin(),vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(),vehicle.getPrice()));

            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                bufWriter.write(String.format("%.2f|%.2f|%.2f|%.2f|%s|%.2f", salesContract.getSalesTaxAmount(), salesContract.getRecordingFee(), salesContract.getProcessingFee(),salesContract.getTotalPrice(), salesContract.isFinanced(),salesContract.getMonthlyPayment()));
                bufWriter.newLine();
            }
            else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                bufWriter.write(String.format("%.2f|%.2f|%.2f|%.2f", leaseContract.getExpectedEndingValue(), leaseContract.getLeaseFee(), leaseContract.getTotalPrice(),leaseContract.getMonthlyPayment()));
                bufWriter.newLine();
            }

            bufWriter.close(); //Saves file
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

