package com.wcs.monmarchecheckpoint4back.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.wcs.monmarchecheckpoint4back.dto.ShoppingListDto;
import com.wcs.monmarchecheckpoint4back.entity.ShoppingList;
import com.wcs.monmarchecheckpoint4back.repository.ShoppingListRepository;

@CrossOrigin
@RestController
@RequestMapping("/lists")
public class ShoppingListController {

	@Autowired
	ShoppingListRepository shoppingListRepository;

	// Get all seasons

	@GetMapping
	public List<ShoppingList> getArticles() {
		return shoppingListRepository.findAll();
	}

	// Get season by ID

	@GetMapping("/{id}")
	public ShoppingList getById(@PathVariable(required = true) Long id) {
		Optional<ShoppingList> optShoppingList = shoppingListRepository.findById(id);
		if (optShoppingList.isPresent()) {
			return optShoppingList.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	// Create shoppingList
	
	@PostMapping
	public ShoppingList create(@Valid @RequestBody ShoppingListDto shoppingListDto) {
		
		ShoppingList shoppingList = new ShoppingList();
		shoppingList.setName(shoppingListDto.getName());
	
		
		return shoppingListRepository.save(shoppingList);
	}
	
	
	// Update shoppingList
	
	// DeleteShoppingList
	
	   @DeleteMapping("/{id}")
	    public void delete(@PathVariable(required = true) Long id) {
	        shoppingListRepository.deleteById(id);
	    }

}
