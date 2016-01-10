/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solera.codingexercise.model;

/**
 * Represents a discount offer available on items. 
 * @author Chris
 */
public interface Offer {
      public void addItem(Item item);
      public boolean isAchieved();
      public int getDiscount();
}
