package com.example.aprianto.quickcashier;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aprianto on 1/22/2018.
 */

public class Menu implements Parcelable {

    private String kode;
    private String nama;
    private String gbr;
    private Integer harga;

    //GETTER AND SETTER
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

    public String getGbr() {
        return gbr;
    }

    public void setGbr(String gbr) {
        this.gbr = gbr;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }


    //PARCELABLE
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kode);
        dest.writeString(this.nama);
        dest.writeString(this.gbr);
        dest.writeValue(this.harga);
    }

    public Menu() {
    }

    protected Menu(Parcel in) {
        this.kode = in.readString();
        this.nama = in.readString();
        this.gbr = in.readString();
        this.harga = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel source) {
            return new Menu(source);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };
}
