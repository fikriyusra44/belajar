package com.belajar.spring.service.impl;

import com.belajar.spring.dao.KrsDAO;
import com.belajar.spring.dao.MahasiswaDAO;
import com.belajar.spring.entity.KRS;
import com.belajar.spring.entity.Mahasiswa;
import com.belajar.spring.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KrsServiceImpl implements KrsService {

    @Autowired
    private KrsDAO KrsDAO;

    @Override
    public KRS save(KRS param) {
        return KrsDAO.save(param);
    }

    @Override
    public KRS update(KRS param) {
        return KrsDAO.update(param);
    }

    @Override
    public int delete(KRS param) {
        return KrsDAO.delete(param);
    }

    @Override
    public List<KRS> find() {
        return KrsDAO.find();
    }

    @Override
    public KRS findById(int id) {
        return KrsDAO.findById(id);
    }


}
