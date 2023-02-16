package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT };
	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT, SUB_MENU_FINISH_TRANSACTION };

	private Menu menu;
	private VendingMachineApp vendingMachine = new VendingMachineApp();
	private Map<String, VendingMachineItem> productSelected = new TreeMap<>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			for(Map.Entry<String, VendingMachineItem> entry: vendingMachine.getProductSelected().entrySet()) {

				System.out.println(entry.getKey()+" "+ entry.getValue().getName()+" "+ entry.getValue().getPrice()+" "+ entry.getValue().getQty());
			}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				Scanner userInput = new Scanner(System.in);
				System.out.print("Please enter the item number");
				String productSelected = userInput.nextLine(); {
					choice = (String) ;

				}



				runSubMenu();
			} else if(choice.equals(MAIN_MENU_EXIT)) {
				break;
			}
		}
	}

	public void runSubMenu(){
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

			if (choice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
				break;
			}
			else if (choice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
				break;
			}
			else if (choice.equals(SUB_MENU_FINISH_TRANSACTION)) {
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
