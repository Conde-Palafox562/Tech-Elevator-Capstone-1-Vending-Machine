package com.techelevator;

import java.math.BigDecimal;

public class VendingMachineItem {

    private String slotNumber = "";
    private String name = "";
    private BigDecimal price;
    private int qty = 5;
    private String sound = "";

    public VendingMachineItem(String slotNumber, String name, BigDecimal price,String sound) {
        this.slotNumber = slotNumber;
        this.name = name;
        this.price = price;
        this.sound = sound;

    }

    public VendingMachineItem() {

    }

    public String getSound(){
        return sound;
    }
    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}