package com.javainuse.repository;


import com.javainuse.entity.ChuyenBay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenBayReponsitory extends CrudRepository<ChuyenBay, String> {
    public List<ChuyenBay> findAllBy();
    public List<ChuyenBay> findChuyenBayByGaDen(String gaDen);
    @Query(value = "SELECT * FROM chuyenbay WHERE do_dai > 8000 and do_dai < 10000",nativeQuery = true)
    public List<ChuyenBay> findChuyenBaysByDoDai();
    @Query(value = "SELECT * FROM chuyenbay WHERE ga_di = 'SGN' and ga_den = 'BMV' ",nativeQuery = true)
    public List<ChuyenBay> findChuyenBaysSGNtoBMV();
    @Query(value = "SELECT (count(*)) FROM chuyenbay WHERE ga_di = 'SGN'",nativeQuery = true)
    public int findChuyenBayBySGN();

    @Query(value = "SELECT * FROM chuyenbay WHERE ga_di = 'SGN'",nativeQuery = true)
    public List<ChuyenBay> findChuyenBaysBySGN();

    @Query(value = "SELECT * FROM chuyenbay where do_dai < 4168", nativeQuery = true)
    List<ChuyenBay> findChuyenBayByVN280();

    @Query(value = "select * from chuyenbay\n" +
            "            where (select tam_bay from maybay where Loai = 'Airbus A320') > do_dai", nativeQuery = true)
    public List<ChuyenBay> chuyenBayDuoCBayBoiAirbus320();

    @Query(value = "select * from chuyenbay where ga_di in (select ga_den from chuyenbay) and ga_den in (select ga_di from chuyenbay)", nativeQuery = true)
    public List<ChuyenBay> lstChuyenBayDiThang();

    @Query(value = "SELECT * FROM chuyenbay WHERE gio_di < '12:00:00'", nativeQuery = true)
    List<ChuyenBay> findChuyenBayByGioDiBefore12();

    @Query(value = "SELECT * FROM chuyenbay WHERE ga_di like ?1 and gio_di > '12:00:00'", nativeQuery = true)
    List<ChuyenBay> findChuyenBayByGaDiGioBefore12(String gaDi);

    @Query(value = "select ga_di, COUNT(ga_di) from chuyenbay group by ga_di",nativeQuery = true)
    public List<String> getGaDi();

    @Query(value = "select  ga_di, SUM(chi_phi) as \"Tong Chi Phi\" from chuyenbay group by ga_di",nativeQuery = true)
    public List<String> lstTongChiPhi();

    @Query(value = "select * from chuyenbay where chuyenbay.gio_di < '12:00' group by ga_di", nativeQuery = true)
    public List<ChuyenBay> lstChuyenBayKhoiHanhTruoc12hTaiMoiGa();

    @Query(value = "select distinct cb.* from chuyenbay cb, maybay mb\n" +
            "            where cb.do_dai < mb.tam_bay and Loai  Like 'Boeing%'",nativeQuery = true)
    public List<ChuyenBay> lstChuyenBayBayBangBoeing();

}
