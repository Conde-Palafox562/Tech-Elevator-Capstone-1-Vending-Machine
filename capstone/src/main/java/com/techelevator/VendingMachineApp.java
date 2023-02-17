package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachineApp {
    private Menu menu;

    private Map<String, VendingMachineItem> productSelected = new TreeMap<>();

    public Map<String, VendingMachineItem> getProductSelected() {
        return productSelected;
    }

    public VendingMachineApp() {

        String itemMenu = "vendingmachine.csv";

        //They gave us a file name, so let's create a file object
        File file = new File(itemMenu);

        //Because the file is an external resource and may have been deleted at some point,
        // or the user gave us the wrong path - we want to make sure this is in a try
        // because there is an opportunity for it to throw an exception
        try (Scanner fileScanner = new Scanner(file)) {

            //As long as there is a line of text in the file to read,
            // keep reading it
            while (fileScanner.hasNextLine()) {

                //Get the individual line of text
                String line = fileScanner.nextLine();

                // break the line into separate parts based on where the space is
                String[] splitLine = line.split("\\|");

                //get the category
                String slotNumber = splitLine[0];
                String name = splitLine[1];
                BigDecimal price = new BigDecimal(splitLine[2]);
                String category = splitLine[3];

                if (category.equals("Drink")) {
                    Drink drinkSound = new Drink(slotNumber, name, price);
                    productSelected.put(slotNumber, drinkSound);

                }
                if (category.equals("Chip")) {
                    Chip chipSound = new Chip(slotNumber, name, price);
                    productSelected.put(slotNumber, chipSound);

                }
                if (category.equals("Gum")) {
                    Gum gumSound = new Gum(slotNumber, name, price);
                    productSelected.put(slotNumber, gumSound);

                }
                if (category.equals("Candy")) {
                    Candy candySound = new Candy(slotNumber, name, price);
                    productSelected.put(slotNumber, candySound);

                }

                //Iterate through our map and print out all of our categories and totals
                for (Map.Entry<String, VendingMachineItem> entry : productSelected.entrySet()) {
             //       System.out.println(entry.getKey() + ": $" + entry.getValue());
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
    }
public void purchase() {

}

}