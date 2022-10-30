package com.javainuse.controller;


import com.javainuse.entity.ChuyenBay;
import com.javainuse.service.ChuyenBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chuyenbay")
public class ChuyenBayController {
    @Autowired
    private ChuyenBayService chuyenBayService;

    @GetMapping("/chuyenBayDAD")
    public List<ChuyenBay> listChuyenBayDAD() {
        return chuyenBayService.findChuyenBayByGaDen("DAD");
    }

    @GetMapping("/chuyenBayByDoDai")
    public List<ChuyenBay> listChuyenBayByDoDai() {
        return chuyenBayService.chuyenBayCau4();
    }


    @GetMapping("/chuyenBaySNGtoBMV")
    public List<ChuyenBay> listChuyenBayCau5() {
        return chuyenBayService.chuyenBayCau5();
    }

    @GetMapping("/chuyenBayCau6")
    public List<ChuyenBay> listChuyenBayCau6() {
        return chuyenBayService.chuyenBayCau6();
    }

    @GetMapping("/chuyenBayCau13")
    public List<ChuyenBay> listChuyenBayCau13() {
        return chuyenBayService.chuyenBayCau13();
    }
    @GetMapping("/chuyenBayCau14")
    public List<ChuyenBay> listChuyenBayCau14() {
        return chuyenBayService.chuyenBayCau14();
    }

    @GetMapping("/chuyenBayCau17")
    public List<ChuyenBay> listChuyenBayCau17() {
        return chuyenBayService.chuyenBayCau17();
    }

    @GetMapping("/chuyenBayCau18")
    public List<String> listChuyenBayCau18() {
        return chuyenBayService.chuyenBayCau18();
    }

    @GetMapping("/chuyenBayCau19")
    public List<String> listChuyenBayCau19() {
        return chuyenBayService.chuyenBayCau19();
    }

    @GetMapping("/chuyenBayCau20")
    public List<ChuyenBay> listChuyenBayCau20() {
        return chuyenBayService.chuyenBayCau20();
    }

    @GetMapping("/chuyenBayCau21")
    public List<ChuyenBay> listChuyenBayCau21() {
        return chuyenBayService.chuyenBayCau21();
    }

    @GetMapping("/chuyenBayCau28")
    public List<ChuyenBay> listChuyenBayCau28() {
        return chuyenBayService.chuyenBayCau28();
    }
}
