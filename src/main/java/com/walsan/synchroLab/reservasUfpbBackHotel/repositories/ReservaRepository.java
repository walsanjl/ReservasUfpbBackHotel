package com.walsan.synchroLab.reservasUfpbBackHotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
}
