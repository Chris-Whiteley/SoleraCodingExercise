/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solera.codingexercise.service;

import com.solera.codingexercise.dao.MockItemDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris
 */
public class CheckOutTest {

    public CheckOutTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getReceipt method, of class CheckOut.
     */
    @Test
    public void testGetReceipt() {
        System.out.println("getReceipt");
        
        System.out.println("\nTest 2 Papayas - no offer");
        System.out.println("-------------------------\n");
        
        String[] shoppingBasket = {"Apples", "Papayas", "Oranges", "Oranges", "Papayas", "Garlic"};
        CheckOut checkout = new CheckOut(new MockItemDAO());
        for (String item : shoppingBasket) {
            checkout.addScannedItem(item);
        }

        int expResult = 200;
        int result = checkout.getTotal();

        System.out.print(checkout.getReceipt());
        assertEquals(expResult, result);

        System.out.println("\nTest 3 Papayas - get offer");
        System.out.println("--------------------------\n");
 
        String[] shoppingBasket2 = {"Apples", "Papayas", "Oranges","Papayas", "Oranges", "Papayas", "Garlic"};
        checkout = new CheckOut(new MockItemDAO());
        for (String item : shoppingBasket2) {
            checkout.addScannedItem(item);
        }

        expResult = 200;
        result = checkout.getTotal();
        System.out.print(checkout.getReceipt());
        assertEquals(expResult, result);        

        System.out.println("\nTest 4 Papayas - should only get 1 off");
        System.out.println("--------------------------------------\n");

        // test case where get 4 Papayas - should only get the one off
 
        String[] shoppingBasket3 = {"Papayas", "Apples", "Papayas", "Oranges","Papayas", "Oranges", "Papayas", "Garlic"};
        checkout = new CheckOut(new MockItemDAO());
        for (String item : shoppingBasket3) {
            checkout.addScannedItem(item);
        }

        expResult = 250;
        result = checkout.getTotal();
        System.out.print(checkout.getReceipt());
        assertEquals(expResult, result);        

    }

}
