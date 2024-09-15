package com.codewithjoewus;
import java.util.Scanner;

public class Mortgage {
    public void calculateMortgage() {
        double amount = 0;
        double principal = 0;
        double rate = 0;
        int numberOfMonths = 0;

        System.out.println("Welcome to the mortgage calculator");

        Scanner scanner = new Scanner(System.in);

        // Get principal amount
        System.out.println("Please enter your principal amount: ");
        principal = scanner.nextDouble(); 
        if (principal <= 0) {
            System.out.println("Principal amount must be greater than 0.");
            scanner.close();
            return;
        }

        System.out.println("Your Principal is: " + principal);

        // Get annual interest rate
        System.out.println("Enter the annual interest rate (in percentage): ");
        rate = scanner.nextDouble();
        if (rate < 0) {
            System.out.println("Interest rate cannot be negative.");
            scanner.close();
            return;
        }

        // Convert annual rate to monthly rate
        double monthlyRate = rate /(double) 12 /(double) 100;

        // Get number of months
        System.out.println("Enter the number of months: ");
        numberOfMonths = scanner.nextInt();
        if (numberOfMonths <= 0) {
            System.out.println("Number of months must be greater than 0.");
            scanner.close();
            return;
        }

        // Mortgage calculation
        double numerator = monthlyRate * Math.pow(1 + monthlyRate, numberOfMonths);
        double denominator = Math.pow(1 + monthlyRate, numberOfMonths) - 1;
        amount = principal * numerator / denominator;

        // Output the monthly payment
        System.out.printf("Your monthly payment is:$%.2f%n", amount);
        //There is a currency method which i willresearch and implement later..!

        scanner.close();
    }
}

