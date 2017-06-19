/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servermerchant.model;

/**
 *
 * @author Arina Listyarini DA
 */
public class TransaksiBarang {
    private String idTransaksiBarang;
    private String idBarang;
    private int jumlah;

    public String getIdTransaksiBarang() {
        return idTransaksiBarang;
    }

    public void setIdTransaksiBarang(String idTransaksiBarang) {
        this.idTransaksiBarang = idTransaksiBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
}
