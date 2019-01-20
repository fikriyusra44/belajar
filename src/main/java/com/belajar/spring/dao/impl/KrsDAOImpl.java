package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.KrsDAO;
import com.belajar.spring.entity.KRS;
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
public class KrsDAOImpl implements KrsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public KRS save(KRS param) {

        String sql = "INSERT INTO " + Table.TABLE_KRS + " (id_krs, id_mahasiswa, mata_kuliah, tahun_akademik) VALUES (?, ?, ?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getIdKRS());
            ps.setInt(2, param.getIdMahasiswa());
            ps.setString(3, param.getMataKuliah());
            ps.setString(4, param.getTahunAkademik());
            return ps;
        }, keyHolder);

        param.setIdKRS(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }


    @Override
    public KRS update(KRS param) {
        String sql = "UPDATE " + Table.TABLE_KRS + " SET " +
                "id_krs = ?, " +
                "id_mahasiswa = ? " +
                "mata_kuliah = ?" +
                "tahun_akademik = ?" +
                "WHERE id =  ? ";

        jdbcTemplate.update(sql,
                param.getIdMahasiswa(),
                param.getMataKuliah(),
                param.getTahunAkademik(),
                param.getIdKRS());

        return param;
    }

    @Override
    public int delete(KRS param) {
        String sql = "DELETE FROM " + Table.TABLE_KRS + " WHERE id = ? ";

        return jdbcTemplate.update(sql, param.getIdKRS());
    }

    @Override
    public List<KRS>find() {

        String sql = "SELECT table_krs.id_krs , table_krs.mata_kuliah, table_mahasiswa.id, table_mahasiswa.nama\n" +
                "FROM table_krs ,table_mahasiswa\n" +
                "WHERE table_krs.id_mahasiswa = table_mahasiswa.id";

                //"SELECT id_krs, id,nama,mata_kuliah FROM table_krs INNER JOIN table_mahasiswa  ON id = id_mahasiswa";
                //"SELECT * FROM " + Table.TABLE_KRS;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(KRS.class));
    }


    @Override
    public KRS findById(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_KRS + " WHERE id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(KRS.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

}
