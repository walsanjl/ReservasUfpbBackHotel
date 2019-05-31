package com.walsan.synchroLab.reservasUfpbBackHotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Hotel;
import com.walsan.synchroLab.reservasUfpbBackHotel.repositories.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel find(Integer id) {
		Optional<Hotel> obj = hotelRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Hotel insert(Hotel obj) {
		obj.setId(null);
		return hotelRepository.save(obj);
	}
	
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			hotelRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Hotel update(Hotel obj) {
		find(obj.getId());
		return hotelRepository.save(obj);
	}
	
	public List<Hotel> findByUf(String uf) {
		return hotelRepository.findByUf(uf);
		//return hotelRepository.
	}
	
	public List<Hotel> findByEstrelas(Integer estrelas) {
		return hotelRepository.findByEstrelas(estrelas);
		//return hotelRepository.
	}
	
	public List<Hotel> findByUfAndEstrelas(String uf, Integer estrelas) {
		return hotelRepository.findByUfAndEstrelas(uf, estrelas);
		//return hotelRepository.
	}
}
