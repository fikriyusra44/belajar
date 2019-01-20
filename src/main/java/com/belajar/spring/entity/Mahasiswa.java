package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Mahasiswa implements Serializable {

    private int id;

    private String nama;

    private String alamat;

    private String fakultas;

    private String jurusan;

    //private List<KRS>krsList;

    public Mahasiswa() {
    }

    public Mahasiswa(int id) {
        this.id = id;
    }

    public Mahasiswa(String nama, String alamat, String fakultas, String jurusan) {
        this.nama = nama;
        this.alamat = alamat;
        this.fakultas = fakultas;
        this.jurusan = jurusan;
    }

    public Mahasiswa(int id, String nama, String alamat, String fakultas, String jurusan) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.fakultas = fakultas;
        this.jurusan = jurusan;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNama() { return nama; }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public String getFakultas() {
//        return fakultas;
//    }
//
//    public void setFakultas(String fakultas) { this.fakultas = fakultas; }
//
//    public String getJurusan() {
//        return jurusan;
//    }
//
//    public void setJurusan(String jurusan) {
//        this.jurusan = jurusan;
//    }

}
