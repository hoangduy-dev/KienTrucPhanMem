package com.javainuse.service;

import com.javainuse.entity.MayBay;
import com.javainuse.repository.MayBayReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MayBayService {
    @Autowired
    private MayBayReponsitory mayBayReponsitory;

    public List<MayBay> listMayBayTamBaylte10000() {
        List<MayBay> mayBays = mayBayReponsitory.findMayBaysByTamBay();
        return (List<MayBay>) mayBayReponsitory.saveAll(mayBays);
    }

    public List<MayBay> mayBayCau7() {
        List<MayBay> mayBays = mayBayReponsitory.findMayBaysByLoaiBoeing();
        return (List<MayBay>) mayBayReponsitory.saveAll(mayBays);
    }

    public List<Integer> mayBayCau11() {
        List<Integer> mayBays = mayBayReponsitory.findMayBaysByNV();
        return mayBays;
    }

    public List<String> mayBayCau16() {
        List<String> mayBays = mayBayReponsitory.loaiMayBayCoPhiCongLai();
        return mayBays;
    }
}
