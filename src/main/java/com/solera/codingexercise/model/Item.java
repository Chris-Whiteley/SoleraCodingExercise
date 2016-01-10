/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solera.codingexercise.model;

/**
 * Represents a shopping item. In a real system this would likely come from a
 * database so would be a JPA entity.
 *
 * @author Chris
 */
public class Item {

    private final String name;
    private final int price;
    // @ManyToOne(optional = true)
    private final Offer offer;

    public Item(String name, int price, Offer offer) {
        this.name = name;
        this.price = price;
        this.offer = offer;
    }

    public Item(String name, int price) {
        this(name, price, null);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the offer
     */
    public Offer getOffer() {
        return offer;
    }
    
    @Override
    public String toString() {
        return name;
    }

}
