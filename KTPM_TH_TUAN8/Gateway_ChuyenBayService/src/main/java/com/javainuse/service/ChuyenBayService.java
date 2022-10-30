package com.javainuse.service;


import com.javainuse.entity.ChuyenBay;
import com.javainuse.repository.ChuyenBayReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenBayService {
    @Autowired
    private ChuyenBayReponsitory chuyenBayReponsitory;

    public List<ChuyenBay> findChuyenBayByGaDen(String dad) {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.findChuyenBayByGaDen("DAD");
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public  List<ChuyenBay> chuyenBayCau4() {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.findChuyenBaysByDoDai();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public List<ChuyenBay> chuyenBayCau5() {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.findChuyenBaysSGNtoBMV();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public List<ChuyenBay> chuyenBayCau6() {
       List<ChuyenBay> chuyenBays = chuyenBayReponsitory.findChuyenBaysBySGN();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public List<ChuyenBay> chuyenBayCau13() {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.findChuyenBayByVN280();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public List<ChuyenBay> chuyenBayCau14() {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.chuyenBayDuoCBayBoiAirbus320();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public List<ChuyenBay> chuyenBayCau17() {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.lstChuyenBayDiThang();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public List<String> chuyenBayCau18() {
        List<String> chuyenBays = chuyenBayReponsitory.getGaDi();
        return chuyenBays;
    }

    public List<String> chuyenBayCau19() {
        List<String> chuyenBays = chuyenBayReponsitory.lstTongChiPhi();
        return chuyenBays;
    }

    public List<ChuyenBay> chuyenBayCau20() {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.findChuyenBayByGioDiBefore12();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public List<ChuyenBay> chuyenBayCau21() {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.lstChuyenBayKhoiHanhTruoc12hTaiMoiGa();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }

    public List<ChuyenBay> chuyenBayCau28() {
        List<ChuyenBay> chuyenBays = chuyenBayReponsitory.lstChuyenBayBayBangBoeing();
        return (List<ChuyenBay>) chuyenBayReponsitory.saveAll(chuyenBays);
    }
}
