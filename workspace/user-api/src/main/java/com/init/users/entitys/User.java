package com.init.users.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //Anotarlo como una entidad - obj llevado y recuperado de la BD
@Table(name="users") //es una entidad y se graba en la tabla users

public class User {
	//Con estas especificaciones spring boot me genera la tabla users
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //Propiedad autoincremental
	private long id;
	
	@Column(name="name", nullable=false, length = 30)
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
