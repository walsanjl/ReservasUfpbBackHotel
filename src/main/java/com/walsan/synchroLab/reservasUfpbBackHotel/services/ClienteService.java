package com.walsan.synchroLab.reservasUfpbBackHotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Cliente;
import com.walsan.synchroLab.reservasUfpbBackHotel.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return clienteRepository.save(obj);
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Cliente update(Cliente obj) {
		find(obj.getId());
		return clienteRepository.save(obj);
	}
}
