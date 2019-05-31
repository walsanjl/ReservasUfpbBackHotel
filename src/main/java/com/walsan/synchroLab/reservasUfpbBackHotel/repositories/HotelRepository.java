package com.walsan.synchroLab.reservasUfpbBackHotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
	//@Query("SELECT obj FROM Hotel obj WHERE obj.uf LIKE %:uf")
	List<Hotel> findByUf(String uf);
	List<Hotel> findByEstrelas(Integer estrelas);
	List<Hotel> findByUfAndEstrelas(String uf, Integer estrelas);
}
