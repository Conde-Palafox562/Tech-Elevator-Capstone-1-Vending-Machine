package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class CalculatorInterfaceVM {

    private Map<String, VendingMachineItem> productSelected = new TreeMap<>();
    //public VendingMachineApp vendingMachine = new VendingMachineApp();

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
        String logFile = "C:\\Users\\Student\\workspace\\kbjan-23-capstone-1-team-6\\capstone\\Log.txt";
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            LocalDateTime now = LocalDateTime.now();
            writer.println(dtf.format(now) + "Change dispensed: $" + vendingMachine.getBalance());
        System.out.println(System.lineSeparator() + "Change dispensed: $" + vendingMachine.getBalance());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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

        System.out.println(System.lineSeparator() + "Please take your change. Thank you for choosing the Vendo-Matic 800!" + System.lineSeparator());

        //PrintWriter writer = null;



        BigDecimal VendingMachineApp = vendingMachine.getBalance().subtract(balance);



    }
}
