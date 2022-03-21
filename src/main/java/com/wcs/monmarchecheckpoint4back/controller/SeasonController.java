package com.wcs.monmarchecheckpoint4back.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wcs.monmarchecheckpoint4back.dto.SeasonDto;
import com.wcs.monmarchecheckpoint4back.dto.VegetableDto;
import com.wcs.monmarchecheckpoint4back.entity.Season;
import com.wcs.monmarchecheckpoint4back.entity.Vegetable;
import com.wcs.monmarchecheckpoint4back.repository.SeasonRepository;

@RestController
@RequestMapping("/seasons")
public class SeasonController {
	
	@Autowired
	SeasonRepository seasonRepository;
	
	//Get all seasons
	
	@GetMapping
	public List<Season> getArticles() {
		return seasonRepository.findAll();
	}
	
	//Get season by ID
	
	  @GetMapping("/{id}")
	   public Season getById(@PathVariable  (required = true) Long id ) {
		   Optional<Season> optSeason = seasonRepository.findById(id);
	        if (optSeason.isPresent()) {
	            return optSeason.get();
	        } throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	   }
	  
	  
	  // Create season
	  
		@PostMapping
		public Season create(@Valid @RequestBody SeasonDto seasonDto) {
			
			Season season = new Season();
			season.setName(seasonDto.getName());
		
			
			return seasonRepository.save(season);
		}
	

}
