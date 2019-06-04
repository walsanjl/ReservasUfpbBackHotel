package com.walsan.synchroLab.reservasUfpbBackHotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer>{
	
	List<Quarto> findByHotel_idAndStatus(Integer hotel_id, String status);
	List<Quarto> findByHotel_idAndStatusAndQtdeDeLeitos(Integer hotel_id, String status, Integer qtdeDeLeitos);
	List<Quarto> findByHotel_id(Integer hotel_id);
	Quarto findByIdAndHotel_id(Integer quarto_id, Integer hotel_id);
}
