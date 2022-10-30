package com.javainuse.repository;

import com.javainuse.entity.MayBay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MayBayReponsitory extends CrudRepository<MayBay, Integer> {

    @Query(value = "SELECT * FROM maybay WHERE tam_bay > 10000", nativeQuery = true)
    List<MayBay> findMayBaysByTamBay();

    @Query(value = "SELECT * FROM maybay WHERE loai LIKE 'Boeing%'", nativeQuery = true)
    List<MayBay> findMayBaysByLoaiBoeing();
    @Query(value = "SELECT DISTINCT mamb FROM maybay " +
            " JOIN chungnhan c on maybay.mamb = c.maybay_mamb " +
            " JOIN nhanvien n on n.manv = c.nhanvien_manv " +
            " WHERE n.ten LIKE 'Nguyen%' ", nativeQuery = true)
    List<Integer> findMayBaysByNV();

    @Query(value = "select  mamb, Loai, COUNT(n.manv) from maybay\n" +
            "                   join chungnhan c on maybay.mamb = c.maybay_mamb\n" +
            "                   join nhanvien n on n.manv = c.nhanvien_manv\n" +
            "group by maybay.loai",nativeQuery = true)
    public List<String> loaiMayBayCoPhiCongLai();

    @Query(value = "SELECT mamb, loai, COUNT(N.manv) FROM maybay\n" +
            "    JOIN chungnhan c on maybay.mamb = c.maybay_mamb\n" +
            "    JOIN nhanvien n on n.manv = c.nhanvien_manv\n" +
            "WHERE manv IN (SELECT C.nhanvien_manv FROM chungnhan) AND loai LIKE ?1 ", nativeQuery = true)
    List<String> findMayBaysByLoai(String loai);

}
