package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Map;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT };
	private static final String SUB_MENU_OPTION_DISPLAY_ITEMS = "Feed Money";
	private static final String SUB_MENU_OPTION_PURCHASE = "Select Product";
	private static final String SUB_MENU_EXIT = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_OPTION_DISPLAY_ITEMS, SUB_MENU_OPTION_PURCHASE, SUB_MENU_EXIT };

	private Menu menu;
	private VendingMachineApp vendingMachine = new VendingMachineApp();

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

				runSubMenu();
			} else if(choice.equals(MAIN_MENU_EXIT)) {
				break;
			}
		}
	}

	public void runSubMenu(){
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

			if (choice.equals(SUB_MENU_EXIT)) {
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
