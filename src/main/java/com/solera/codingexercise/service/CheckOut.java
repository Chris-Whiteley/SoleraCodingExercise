/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solera.codingexercise.service;

import com.solera.codingexercise.dao.ItemDAO;
import com.solera.codingexercise.model.Item;
import com.solera.codingexercise.model.Offer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chris
 */
public class CheckOut {

    private final ItemDAO dao;
    private final List<Item> items;
    private final Map<String, Offer> offersInProgressMap;

    public CheckOut(ItemDAO dao) {
        this.dao = dao;
        items = new ArrayList<>();
        offersInProgressMap = new HashMap<>();
    }

    /**
     * Adds the scanned Item to the list of items and applies any offer discount
     * that has been achieved.
     *
     * @param itemName
     */
    public void addScannedItem(String itemName) {
        Item item = dao.findByName(itemName);
        items.add(item);
        Offer offer = getAcheivedOffer(item);
        if (offer != null) {
            Item discountItem = new Item("  ***" + offer, -offer.getDiscount());
            items.add(discountItem);
        }
    }

    public int getTotal() {
        int total = 0;

        for (Item item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public String getReceipt() {

        StringBuilder sb = new StringBuilder();
        sb.append("RECEIPT\n");
        sb.append("=======\n\n");
        for (Item i : items) {
            sb.append(String.format("%-30s %8s %n", i, format(i.getPrice())));
        }
        sb.append(String.format("%n%-30s %8s %n", "TOTAL", format(getTotal())));
        return sb.toString();
    }

    /**
     *
     * @param value
     * @return
     */
    private String format(int value) {
        String s = Integer.toString(value);

        int len = s.length();
        if (len == 1) {
            s = ".0" + s;
        } else if (len == 2) {
            s = "." + s;
        } else {
            String l = s.substring(0, len - 2);
            String r = s.substring(len - 2);
            s = l + "." + r;
        }

        Double d = Double.parseDouble(s);
        return NumberFormat.getCurrencyInstance().format(d);
    }

    /**
     * Gets and offer that has been achieved on this item or returns null.
     *
     * @param item
     * @return
     */
    private Offer getAcheivedOffer(Item item) {
        Offer offer = item.getOffer();
        if (offer != null) {
            // if we already have an offer in progress for this item then use that else save this offer as the offer in progress.
            if (offersInProgressMap.containsKey(item.getName())) {
                offer = offersInProgressMap.get(item.getName());
            } else {
                offersInProgressMap.put(item.getName(), offer);
            }

            // add the item to the offer and check if the offer has been achieved
            // if it has then remove it from offers in progress map otherwise set the offer to null as it has not been acheived yet.
            offer.addItem(item);
            if (offer.isAchieved()) {
                offersInProgressMap.remove(item.getName());
            } else {
                offer = null;
            }
        }
        return offer;
    }

}
