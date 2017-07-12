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
public class ArrayTransaksi {
    private ArrayList<Transaksi> transaksis;

    public ArrayTransaksi() {
        transaksis = new ArrayList<Transaksi>();
    }

    public ArrayList<Transaksi> getTransaksis() {
        return transaksis;
    }

    public void setTransaksis(ArrayList<Transaksi> transaksis) {
        this.transaksis = transaksis;
    }
}
