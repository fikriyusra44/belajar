package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class KRS implements Serializable {
    private int idKRS;

    private int idMahasiswa;

    private String mataKuliah;

    private String tahunAkademik;

    public KRS() {
    }

    public KRS(int idKRS) {
        this.idKRS = idKRS;
    }

    public KRS(int idMahasiswa, String mataKuliah, String tahunAkademik) {
        this.idMahasiswa = idMahasiswa;
        this.mataKuliah = mataKuliah;
        this.tahunAkademik = tahunAkademik;
    }

    public KRS(int idKRS, int idMahasiswa, String mataKuliah, String tahunAkademik) {
        this.idMahasiswa = idMahasiswa;
        this.mataKuliah = mataKuliah;
        this.tahunAkademik = tahunAkademik;
        this.idKRS = idKRS;
    }
}
