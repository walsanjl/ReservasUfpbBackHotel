package com.walsan.synchroLab.reservasUfpbBackHotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
