/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solera.codingexercise.model;

/**
 *
 * @author Chris
 */
public class BuyXGetYFreeOffer implements Offer {

    private final String name;
    private int itemCount;
    private int discount;
    private boolean achieved;
    private final int x;
    private final int y;

    public BuyXGetYFreeOffer(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public BuyXGetYFreeOffer(BuyXGetYFreeOffer offer) {
        this.name = offer.name;
        this.x = offer.x;
        this.y = offer.y;
    }

    @Override
    public void addItem(Item item) {
        itemCount++;
        if (itemCount == x) {
            achieved = true;
            discount = item.getPrice() * y;
        }
    }

    @Override
    public boolean isAchieved() {
        return achieved;
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
