/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solera.codingexercise.dao;

import com.solera.codingexercise.model.BuyXGetYFreeOffer;
import com.solera.codingexercise.model.Item;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Chris
 */
public class MockItemDAO implements ItemDAO {
    
    Map <String, Item> itemMap;
    
    public MockItemDAO () {
        itemMap = new HashMap<>();
        
        // populate itemMap with sample values
        itemMap.put ("Apples", new Item("Apples", 25));
        itemMap.put ("Oranges", new Item("Oranges", 30));
        itemMap.put ("Garlic", new Item("Garlic", 15));
        itemMap.put ("Papayas", new Item("Papayas", 50, new BuyXGetYFreeOffer("3 for the price of 2",3,1)));
    }
    
    @Override
    public Item findByName(String name) {
        Item item = itemMap.get(name);        
        BuyXGetYFreeOffer offer = (item.getOffer()==null?null:new BuyXGetYFreeOffer((BuyXGetYFreeOffer) item.getOffer()));
        return new Item(item.getName(),item.getPrice(),offer);
    }
    
}
