package com.example.dedijun.varianpasta;

/**
 * Created by iqbalzauqul on 11/12/17.
 */

// model
public class menu {

    private String nama;
    private String image;
    private int harga;

    public menu(String nama, String image, int harga) {
        this.nama = nama;
        this.image = image;
        this.harga = harga;
    }
    menu () {}


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
