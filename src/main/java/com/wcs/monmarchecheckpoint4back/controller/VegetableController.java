package com.wcs.monmarchecheckpoint4back.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wcs.monmarchecheckpoint4back.dto.VegetableDto;
import com.wcs.monmarchecheckpoint4back.entity.Vegetable;
import com.wcs.monmarchecheckpoint4back.repository.VegetableRepository;

@CrossOrigin
@RestController
@RequestMapping("/vegetables")
public class VegetableController {
	
	@Autowired
	VegetableRepository vegetableRepository;
	
	
	// Get all vegies
	
	@GetMapping
	public List<Vegetable> getAll() {
		return vegetableRepository.findAll(Sort.by("name"));
	}
	
	//Get vegie by ID
	
	  @GetMapping("/{id}")
	   public Vegetable getById(@PathVariable  (required = true) Long id ) {
		   Optional<Vegetable> optVegetable = vegetableRepository.findById(id);
	        if (optVegetable.isPresent()) {
	            return optVegetable.get();
	        } throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	   }
	  
	  // Create vegie
	  
		@PostMapping
		public Vegetable create(@Valid @RequestBody VegetableDto vegetableDto) {
			
			Vegetable vegetable = new Vegetable();
			vegetable.setName(vegetableDto.getName());
			vegetable.setDescription(vegetableDto.getDescription());
		
			
			return vegetableRepository.save(vegetable);
		}
		
		

		@DeleteMapping("/{id}")
		public void delete(@PathVariable(required = true) Long id) {
			vegetableRepository.deleteById(id);
		}
		

}
