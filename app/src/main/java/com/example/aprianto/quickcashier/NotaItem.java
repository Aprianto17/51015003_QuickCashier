package com.example.aprianto.quickcashier;

/**
 * Created by Aprianto on 2/6/2018.
 */

public class NotaItem {

    private String kode;
    private String nama;
    private Integer quantity = 0;
    private Integer harga = 0;
    private Integer jumlahHarga = 0;

    //GETTER & SETTER

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.setJumlahHarga( quantity * this.getHarga() );
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
        this.setJumlahHarga( this.getQuantity() * harga );
    }

    public Integer getJumlahHarga() {
        return jumlahHarga;
    }

    public void setJumlahHarga(Integer jumlahHarga) {
        this.jumlahHarga = jumlahHarga;
    }
}
