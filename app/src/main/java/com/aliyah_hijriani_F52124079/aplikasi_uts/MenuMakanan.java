package com.aliyah_hijriani_F52124079.aplikasi_uts;

public class MenuMakanan {
    private String namaMenu;
    private String harga;
    private String kategori;
    private String deskripsi;
    private int fotoResId;

    public MenuMakanan(String namaMenu, String harga, String kategori, String deskripsi, int fotoResId) {
        this.namaMenu = namaMenu;
        this.harga = harga;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.fotoResId = fotoResId;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public String getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getFotoResId() {
        return fotoResId;
    }
}