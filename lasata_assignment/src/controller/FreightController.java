package controller;

import java.util.Scanner;

public class FreightController {
    int[] freightId = new int[100];
    String[] freightStatus = new String[100];
    double[] freightAmount = new double[100];
    int counter = 0;
    int voucherCounter = 0;

    int[] voucherCode = new int[100];
    double[] voucherAmount = new double[100];


    public boolean checkWeight(double weight) {
        return weight <= 20;
    }

    public boolean checkDistance(double distance) {
        return distance <= 5000;
    }

    public double rateAccordingToWeight(double weight) {
        if (weight <= 2) {
            return 5.12;
        }
        if (weight <= 6) {
            return 6.20;
        }

        if (weight <= 10) {
            return 8.70;
        }
        return 10.80;
    }

    public boolean addFreightOrder() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Weight of the parcel: ");
        double weight = scan.nextDouble();
        if (!checkWeight(weight)) {
            System.out.println("Sorry, Minimum weight exceeded!");
            return false;
        }

        System.out.println("Distance to destination: ");
        double distance = scan.nextDouble();
        if (!checkDistance(distance)) {
            System.out.println("Sorry, minimum distance exceeded.");
            return false;
        }

        double rate = rateAccordingToWeight(weight);
        double cost = rate;
        if (distance > 5) {
            cost = rate * distance / 5;
        }
        System.out.println("without discount: " + cost);

        System.out.println("Enter voucher code if any (0 if none): ");
        int userVoucherCode = scan.nextInt();
        if (userVoucherCode > 0) {
            int loopCounter = 0;
            if (loopCounter < voucherCounter) {
                if (voucherCode[loopCounter] == userVoucherCode) {
                    cost = cost - voucherAmount[loopCounter];
                }
            }
        }
        System.out.println(cost);

        freightId[counter] = 1923 + counter;
        freightStatus[counter] = "W";
        freightAmount[counter] = cost;
        counter++;
        double voucherValue = 0.2 * cost;
        voucherCode[voucherCounter] = 1;
        voucherAmount[voucherCounter] = voucherValue;
        voucherCounter++;

        return true;


    }

    public boolean updateFreight() {
        Scanner scan = new Scanner(System.in);
        displayFreights();

        System.out.println("Enter id of freight to change(Negative to exit): ");
        int id = scan.nextInt();
        if (id < 0) {
            return false;
        }

        if (id < 1923 && id > 1923 + counter) {
            System.out.println("Id doesnt match.");
            return false;
        }

        System.out.println("Enter new status: ");
        String status = scan.next();
        if (!status.equals("W") && !status.equals("P") && !status.equals("D")) {
            System.out.println("Status is invalid.");
        }

        updateStatus(id, status);
        return true;
    }

    void updateStatus(int id, String status) {
        int counter = id - 1923;
        freightStatus[counter] = status;
    }

    public void displayFreights() {
        System.out.println("Freight ID\t|\tFreight Amount");
        int localCounter = 0;
        while (localCounter < counter) {
            System.out.println(freightId[localCounter] + "\t|\t" + freightStatus[localCounter] + "\t|\t" + freightAmount[localCounter]);
            localCounter++;

        }
    }

    public void displayVouchers() {
        System.out.println("Voucher ID\t|\tVoucher Status\t|\t Voucher Amount");
        int localCounter = 0;
        while (localCounter < voucherCounter) {
            System.out.println(voucherCode[localCounter] + "\t|\t" + voucherAmount[localCounter]);
            localCounter++;
        }
    }
}
