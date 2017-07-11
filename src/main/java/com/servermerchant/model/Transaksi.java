/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servermerchant.model;

import java.util.Date;
//import java.util.HashMap;

/**
 *
 * @author Arina Listyarini DA
 */
public class Transaksi {
    private Date waktu;
    private int nominal;
    private String idKartu;
    //private HashMap<String, Integer> barangJumlah;

    public String getIdKartu() {
        return idKartu;
    }

    public void setIdKartu(String idKartu) {
        this.idKartu = idKartu;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
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
