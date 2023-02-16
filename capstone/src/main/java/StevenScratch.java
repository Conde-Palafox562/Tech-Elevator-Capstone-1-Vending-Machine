public class StevenScratch {
}
/*

Vending Maching Interface is similar to ATM
Vending Maching is same as Customer
Vending Machine Item is Bank Account (Parent)
CLass Drink - "Glug Glug, Yum!"
Class Candy - "Munch Munch, Yum!"
Class Chip - "Crunch Crunch, Yum!"
Class Gum - "Chew Chew, Yum!"
        Slot# | Item Name | Price |
Sounds to Print

Inventory
map for inventory
keep track of slot location
map of items/qty

Hard code Inventory to 5 at each initial run
//Welcome message to include the
A1|Potato Crisps|3.05|Chip
A2|Stackers|1.45|Chip
A3|Grain Waves|2.75|Chip
A4|Cloud Popcorn|3.65|Chip
B1|Moonpie|1.80|Candy
B2|Cowtales|1.50|Candy
B3|Wonka Bar|1.50|Candy
B4|Crunchie|1.75|Candy
C1|Cola|1.25|Drink
C2|Dr. Salt|1.50|Drink
C3|Mountain Melter|1.50|Drink
C4|Heavy|1.50|Drink
D1|U-Chews|0.85|Gum
D2|Little League Chew|0.95|Gum
D3|Chiclets|0.75|Gum
D4|Triplemint|0.75|Gum

.split in to StringArray is this a line by line split or just the .split ?


runtime exceptions??





/VendingMachine = interface
package vendingmachine.project;

public interface VendingMachine {
    void displayMenu();
    void selectProductsInVM(int product);
    void displayFeedMoney();
    void displayFinishMSG();
}

//CalculatorInterfaceVM = interface
package vendingmachine.project

public interface CalculatorInterfaceVM {

    int currentMoneyProvided(FeedMoney );
    FeedMoney - product cost (int changeToDispense);


}

package vendingmachine.project

public class Main {

public static void Main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    VendingMachine vendingMachine = null //need to initialize
    vendingMachine.displayProducts(File);
    String productSelected = scanner.nextline();
    int productSelectedNumber = Integer.parseInt(productSelected);

    vendingMachine.productSelected(productSelectedNumber);

    vendingMachine.displayFeedMoneyMSG();

    String userMoneyFed = scanner.nextline();

    int[] userMoneyFed = {} // userInput???

    vendingMachine.currentMoneyProvided

}

}

























 */