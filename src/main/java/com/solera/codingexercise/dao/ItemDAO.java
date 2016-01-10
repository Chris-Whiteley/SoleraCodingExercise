/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solera.codingexercise.dao;

import com.solera.codingexercise.model.Item;

/**
 *
 * @author Chris
 */
public interface ItemDAO {

    Item findByName(String name);
}
