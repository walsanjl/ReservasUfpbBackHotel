package com.walsan.synchroLab.reservasUfpbBackHotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Cliente;
import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Quarto;
import com.walsan.synchroLab.reservasUfpbBackHotel.dto.QuartoNewDTO;
import com.walsan.synchroLab.reservasUfpbBackHotel.repositories.HotelRepository;
import com.walsan.synchroLab.reservasUfpbBackHotel.repositories.QuartoRepository;

@Service
public class QuartoService {
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public Quarto find(Integer id) {
		Optional<Quarto> obj = quartoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Quarto insert(Quarto obj) {
		obj.setId(null);
		return quartoRepository.save(obj);
	}
	
	public List<Quarto> findAll() {
		return quartoRepository.findAll();
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			quartoRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Quarto update(Quarto obj) {
		find(obj.getId());
		return quartoRepository.save(obj);
	}
	
	public Quarto fromDTO(QuartoNewDTO objDto) {
		Quarto quarto =  new Quarto(null, objDto.getNumeroDoQuarto(), objDto.getQtdeDeLeitos(), objDto.getPreco(), objDto.getStatus());
		quarto.setHotel( hotelRepository.findById(objDto.getIdDoHotel()).get() );
		quarto.setCliente( new Cliente() );		//o quarto inicia com um objeto Cliente vazio
		return quarto;
	}
	
	public List<Quarto> findByHotel_idAndStatus(Integer hotel_id, String status) {
		return quartoRepository.findByHotel_idAndStatus(hotel_id, status);
	}
	
	public List<Quarto> findByHotel_idAndStatusAndQtdeDeLeitos(Integer hotel_id, String status, Integer qtdeDeLeitos) {
		return quartoRepository.findByHotel_idAndStatusAndQtdeDeLeitos(hotel_id, status, qtdeDeLeitos);
	}
	
	public List<Quarto> findByHotel_id(Integer hotel_id) {
		return quartoRepository.findByHotel_id(hotel_id);
	}
	
	public Quarto findByHotel_idAndQuarto_id(Integer hotel_id, Integer quarto_id) {
		return quartoRepository.findByIdAndHotel_id(quarto_id, hotel_id);
	}
}
