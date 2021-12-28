package com.example.mobileperpus;

import com.google.gson.annotations.SerializedName;
public class Anggota {
    private String nim;
    private String nama;
    private String password;
    private String alamat;
    private String kota;
    private String email;

    @SerializedName("no_telp")
    private String no_telp;

    public Anggota(String nim, String nama, String password, String alamat, String kota, String email, String no_telp) {
        this.nim = nim;
        this.nama = nama;
        this.password = password;
        this.alamat = alamat;
        this.kota = kota;
        this.email = email;
        this.no_telp = no_telp;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
