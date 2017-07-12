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
public class ArrayTransaksiBarang {
    private ArrayList<TransaksiBarang> transaksibarangs;

    public ArrayTransaksiBarang() {
        transaksibarangs = new ArrayList<TransaksiBarang>();
    }

    public ArrayList<TransaksiBarang> getTransaksiBarangs() {
        return transaksibarangs;
    }

    public void setTransaksiBarangs(ArrayList<TransaksiBarang> transaksibarangs) {
        this.transaksibarangs = transaksibarangs;
    }
}
