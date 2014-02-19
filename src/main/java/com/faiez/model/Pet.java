package com.faiez.model;

import javax.persistence.*;

/**
 * Created by faiez.elleuch on 19/02/14.

 */
@Entity
@Table(name="pets")
public class Pet {


	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String color;


	@ManyToOne
	private PetType petType;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}
}
