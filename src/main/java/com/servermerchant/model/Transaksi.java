/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servermerchant.model;

import java.sql.Timestamp;
//import java.util.HashMap;

/**
 *
 * @author Arina Listyarini DA
 */
public class Transaksi {
    private Timestamp waktu;
    private int nominal;
    //private HashMap<String, Integer> barangJumlah;

    public Timestamp getWaktu() {
        return waktu;
    }

    public void setWaktu(Timestamp waktu) {
        this.waktu = waktu;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    /*public HashMap<String, Integer> getBarangJumlah() {
        return barangJumlah;
    }

    public void setBarangJumlah(HashMap<String, Integer> barangJumlah) {
        this.barangJumlah = barangJumlah;
    }*/
}
