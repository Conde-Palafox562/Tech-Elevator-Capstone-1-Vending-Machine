package com.techelevator;

import java.math.BigDecimal;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class CalculatorInterfaceVM {

    private Map<String, VendingMachineItem> productSelected = new TreeMap<>();

    public CalculatorInterfaceVM() {

    }

    public Map<String, VendingMachineItem> getProductSelected() {
        return productSelected;
    }
    private BigDecimal balance = new BigDecimal(0);

    private PrintWriter out;
    private Scanner in;

    public CalculatorInterfaceVM(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public void finishChange(VendingMachineApp vendingMachine) {
        //return change


        System.out.println("Change dispensed: $" + vendingMachine.getBalance());

        BigDecimal changeBalance = vendingMachine.getBalance();

        BigDecimal quarterValue = new BigDecimal("0.25");
        int quarters = 0;

        BigDecimal dimeValue = new BigDecimal("0.10");
        int dimes = 0;

        BigDecimal nickelValue = new BigDecimal("0.05");
        int nickels = 0;

        while (vendingMachine.getBalance().compareTo(quarterValue) >= 0) {
            quarters++;
            vendingMachine.setBalance(vendingMachine.getBalance().subtract(quarterValue));
        }

        while (vendingMachine.getBalance().compareTo(dimeValue) >= 0) {
            dimes++;
            vendingMachine.setBalance(vendingMachine.getBalance().subtract(dimeValue));
        }

        while (vendingMachine.getBalance().compareTo(nickelValue) >= 0) {
            nickels++;
            vendingMachine.setBalance(vendingMachine.getBalance().subtract(nickelValue));
        }

        System.out.println("Quarters: " + quarters + ", " + "Dimes: " + dimes + ", " + "Nickels: " + nickels);

        //zero out balance
        BigDecimal VendingMachineApp = vendingMachine.getBalance().subtract(balance);

        System.out.println(System.lineSeparator() + "Please take your change. Thank you and come again!");


    }
}
