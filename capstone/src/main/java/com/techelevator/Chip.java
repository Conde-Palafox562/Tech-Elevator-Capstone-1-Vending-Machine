package com.techelevator;

import java.math.BigDecimal;

public class Chip extends VendingMachineItem{

    public Chip(String slotNumber, String name, BigDecimal price) {
        super(slotNumber, name, price,"Crunch Crunch, Yum!");

    }
}
