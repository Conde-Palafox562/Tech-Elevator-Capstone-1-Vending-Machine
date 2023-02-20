package com.techelevator;

import com.techelevator.view.Menu;


import java.math.BigDecimal;
import java.util.*;

public class VendingMachineCLI extends VendingMachineItem {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT};
    private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String SUB_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT, SUB_MENU_FINISH_TRANSACTION};

    public Menu menu;
    public VendingMachineApp vendingMachine = new VendingMachineApp();
    private Map<String, VendingMachineItem> productSelected = new TreeMap<>();
    private VendingMachineItem itemsInMachine = new VendingMachineItem();
    public CalculatorInterfaceVM checkOut = new CalculatorInterfaceVM();

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            System.out.println("*******************************");
            System.out.println("Welcome to the Vendo-Matic 800!");
            System.out.println("*******************************");

            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                for (Map.Entry<String, VendingMachineItem> entry : vendingMachine.getProductSelected().entrySet()) {

                    System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getPrice() + " " + entry.getValue().getQty());
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                runSubMenu();

            } else if (choice.equals(MAIN_MENU_EXIT)) {
                break;
            }
        }
    }

    public void runSubMenu() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

            if (choice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
                String customerMoney;

                Scanner userInput = new Scanner(System.in);
                System.out.print(System.lineSeparator() + "Please insert bills only -> $1 / $5 / $10: ");

                customerMoney = userInput.nextLine();
                BigDecimal amount = new BigDecimal(customerMoney);
                vendingMachine.setBalance(amount.add(vendingMachine.getBalance()));
                System.out.println("Current balance is: $" + vendingMachine.getBalance());

           } else if (choice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
                Scanner userInput = new Scanner(System.in);
                System.out.print(System.lineSeparator() + "Please enter the item slot number: ");
                String productSelected = userInput.nextLine().toUpperCase(Locale.ROOT);
                VendingMachineItem item = vendingMachine.getProductSelected().get(productSelected);

                if(vendingMachine.getBalance().compareTo(item.getPrice())>=0){
                    System.out.println(item.getSound());
                    vendingMachine.setBalance(vendingMachine.getBalance().subtract(item.getPrice()));
                    item.setQty(item.getQty()-1);
                    System.out.println(System.lineSeparator() + "Your new balance is: $" + vendingMachine.getBalance());

                } else {
                    System.out.println(System.lineSeparator() + "Insufficient funds! Please feed more money.");
                }

            } else if (choice.equals(SUB_MENU_FINISH_TRANSACTION)) {
                checkOut.finishChange(vendingMachine);

                break;
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}