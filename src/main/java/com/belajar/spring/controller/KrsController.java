package com.belajar.spring.controller;


import com.belajar.spring.entity.KRS;
import com.belajar.spring.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class KrsController {

    @Autowired
    private KrsService service;

    @GetMapping(value = "/KRSan")
    public List<KRS> krsList() {
        return service.find();
    }

    @GetMapping(value = "/KRSan/{id}")
    public KRS findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping(value = "/KRSan")
    public String save(@RequestBody KRS krs) {
        KRS data = service.save(krs);
        if (data.getIdKRS() == 0) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/KRSan")
    public String update(@RequestBody KRS student) {
        KRS data = service.update(student);
        if (data.getIdKRS() == 0) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/KRSan/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int data = service.delete(new KRS(id));
        if (data == 0) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }
}
