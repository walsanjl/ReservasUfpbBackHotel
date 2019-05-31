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

import com.walsan.synchroLab.reservasUfpbBackHotel.domain.Quarto;
import com.walsan.synchroLab.reservasUfpbBackHotel.dto.QuartoNewDTO;
import com.walsan.synchroLab.reservasUfpbBackHotel.services.QuartoService;

@RestController
@RequestMapping(value="/quartos")
public class QuartoResource {
	
	@Autowired
	private QuartoService quartoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Quarto obj = quartoService.find(id);
		return ResponseEntity.ok().body(obj);
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Quarto>> findAll() {
		List<Quarto> listaDeQuartos = quartoService.findAll();
		return ResponseEntity.ok().body(listaDeQuartos);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody QuartoNewDTO objDto) {
		Quarto obj = quartoService.fromDTO(objDto);
		obj = quartoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		quartoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<Void> update(@RequestBody Quarto obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = quartoService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
