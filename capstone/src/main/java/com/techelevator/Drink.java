package com.techelevator;

import java.math.BigDecimal;

public class Drink extends VendingMachineItem{


    public Drink(String slotNumber, String name, BigDecimal price) {
        super(slotNumber, name, price,"Glug Glug, Yum!");

    }
}
