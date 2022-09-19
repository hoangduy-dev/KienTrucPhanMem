package com.tuan4.chuyenbay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuan4.chuyenbay.model.ChuyenBay;
import com.tuan4.chuyenbay.repository.ChuyenBayRepository;

@Service
public class ChuyenBayServiceIml implements ChuyenBayService{

	@Autowired
	private ChuyenBayRepository repository;
	
	@Override
	public List<ChuyenBay> chuyenBayDi(String gaDen) {
		// TODO Auto-generated method stub
		List<ChuyenBay> chuyenBays = repository.findGaDenChuyenBay(gaDen);
		return chuyenBays;
	}

	@Override
	public List<ChuyenBay> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
