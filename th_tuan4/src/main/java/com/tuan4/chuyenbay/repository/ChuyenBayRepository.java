package com.tuan4.chuyenbay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tuan4.chuyenbay.model.ChuyenBay;

@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String>{
	@Query("select c from ChuyenBay c where c.gaDen = ?1")
	List<ChuyenBay> findGaDenChuyenBay(String gaDen);
	
}
