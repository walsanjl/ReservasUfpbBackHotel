package com.walsan.synchroLab.reservasUfpbBackHotel.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Hotel;
import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Quarto;
import com.walsan.synchroLab.reservasUfpbBackHotel.services.HotelService;
import com.walsan.synchroLab.reservasUfpbBackHotel.services.QuartoService;

@RestController
@RequestMapping(value="/hoteis")
public class HotelResource {
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private QuartoService quartoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Hotel obj = hotelService.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(value = "/uf/{uf}", method = RequestMethod.GET)
	public ResponseEntity<?> findByUf(@PathVariable String uf) {
		
		List<Hotel> lista = hotelService.findByUf(uf);
		return ResponseEntity.ok().body(lista);
		
	}
	
	@RequestMapping(value = "/estrelas/{estrelas}", method = RequestMethod.GET)
	public ResponseEntity<?> findByEstrelas(@PathVariable Integer estrelas) {
		List<Hotel> lista = hotelService.findByEstrelas(estrelas);
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value = "uf/{uf}/estrelas/{estrelas}", method = RequestMethod.GET)
	public ResponseEntity<?> findByUfAndEstrelas(@PathVariable String uf, @PathVariable Integer estrelas) {
		List<Hotel> lista = hotelService.findByEstrelas(estrelas);
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value = "id_hotel/{hotel_id}/quarto/{status}", method = RequestMethod.GET)
	public ResponseEntity<?> findByHotel_idAndStatus(@PathVariable Integer hotel_id, @PathVariable String status) {
		List<Quarto> listaDeQuartos = quartoService.findByHotel_idAndStatus(hotel_id, status);
		return ResponseEntity.ok().body(listaDeQuartos);
	}
	
	@RequestMapping(value = "id_hotel/{hotel_id}/quarto/{status}/{qtdeDeLeitos}", method = RequestMethod.GET)
	public ResponseEntity<?> findByHotel_idAndStatusAndQtdeDeLeitos(@PathVariable Integer hotel_id, @PathVariable String status, @PathVariable Integer qtdeDeLeitos) {
		List<Quarto> listaDeQuartos = quartoService.findByHotel_idAndStatusAndQtdeDeLeitos(hotel_id, status, qtdeDeLeitos);
		return ResponseEntity.ok().body(listaDeQuartos);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> findAll() {
		List<Hotel> lista = hotelService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Hotel obj) {
		obj = hotelService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		hotelService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<Void> update(@RequestBody Hotel obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = hotelService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
