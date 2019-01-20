package com.belajar.spring.controller;


import com.belajar.spring.entity.Mahasiswa;
import com.belajar.spring.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MahasiswaController {

    @Autowired
    private MahasiswaService service;

    @GetMapping(value = "/mahasiswas")
    public List<Mahasiswa> mahasiswas() {
        return service.find();
    }

    @GetMapping(value = "/mahasiswas/{id}")
    public Mahasiswa findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping(value = "/mahasiswas")
    public String save(@RequestBody Mahasiswa mahasiswa) {
        Mahasiswa data = service.save(mahasiswa);
        if (data.getId() == 0) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/mahasiswas")
    public String update(@RequestBody Mahasiswa student) {
        Mahasiswa data = service.update(student);
        if (data.getId() == 0) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/mahasiswas/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int data = service.delete(new Mahasiswa(id));
        if (data == 0) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }

}
