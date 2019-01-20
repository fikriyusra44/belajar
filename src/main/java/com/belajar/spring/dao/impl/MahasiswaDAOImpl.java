package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.MahasiswaDAO;
import com.belajar.spring.entity.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;


@Repository
public class MahasiswaDAOImpl implements MahasiswaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mahasiswa save(Mahasiswa param) {
        String sql = "INSERT INTO " + Table.TABLE_MAHASISWA + " (nama, alamat, fakultas, jurusan) VALUES (?, ?, ?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama());
            ps.setString(2, param.getAlamat());
            ps.setString(3, param.getFakultas());
            ps.setString(4, param.getJurusan());
            return ps;
        }, keyHolder);

        param.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

    @Override
    public Mahasiswa update(Mahasiswa param) {
        String sql = "UPDATE " + Table.TABLE_MAHASISWA + " SET " +
                "nama = ?, " +
                "alamat = ? " +
                "fakultas = ?" +
                "jurusan = ?" +
                "WHERE id =  ? ";

        jdbcTemplate.update(sql,
                param.getNama(),
                param.getAlamat(),
                param.getFakultas(),
                param.getJurusan(),
                param.getId());

        return param;
    }

    @Override
    public int delete(Mahasiswa param) {
        String sql = "DELETE FROM " + Table.TABLE_MAHASISWA + " WHERE id = ? ";

        return jdbcTemplate.update(sql, param.getId());
    }

    @Override
    public List<Mahasiswa> find() {
        String sql = "SELECT * FROM " + Table.TABLE_MAHASISWA;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public Mahasiswa findById(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_MAHASISWA + " WHERE id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Mahasiswa.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

}
