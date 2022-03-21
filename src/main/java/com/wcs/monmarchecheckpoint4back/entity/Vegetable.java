package com.wcs.monmarchecheckpoint4back.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Vegetable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	private String name;
	
	//@ManyToOne
	//@JoinColumn(name = "season_id", nullable = false)
	//private Season season;
	
	@ManyToMany
	@JoinTable(name = "vegetable_shoppingList", joinColumns = @JoinColumn(name = "vegetable_id"), inverseJoinColumns = @JoinColumn(name="shoppingList_id"))
	private List<ShoppingList> shoppingLists;
	
	// Getters and Setters

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
