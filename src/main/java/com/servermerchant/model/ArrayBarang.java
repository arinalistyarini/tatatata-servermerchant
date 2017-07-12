/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servermerchant.model;

import java.util.ArrayList;

/**
 *
 * @author Arina Listyarini DA
 */
public class ArrayBarang {
    private ArrayList<Barang> barangs;

    public ArrayBarang() {
        barangs = new ArrayList<Barang>();
    }

    public ArrayList<Barang> getBarangs() {
        return barangs;
    }

    public void setBarangs(ArrayList<Barang> barangs) {
        this.barangs = barangs;
    }
}
