/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servermerchant.model;

import java.util.HashMap;

/**
 *
 * @author Arina Listyarini DA
 */
public class HashMapBarangJumlah {
    private HashMap<String, Integer> barangJumlah;

    public HashMapBarangJumlah() {
        barangJumlah = new HashMap<String, Integer>();
    }
    
    public HashMap<String, Integer> getBarangJumlah() {
        return barangJumlah;
    }

    public void setBarangJumlah(HashMap<String, Integer> barangJumlah) {
        this.barangJumlah = barangJumlah;
    }
}
