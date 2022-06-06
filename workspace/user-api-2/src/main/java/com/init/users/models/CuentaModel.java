package com.init.users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // Indica que es un modelo real
@Table(name = "cuenta") // Dar el nombre a la tabla*/
public class CuentaModel {
	@Id // para que la bd sepa que es un Id.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false) // Es un Id único, autoincrementable, no nulo
	private Long id_cuenta;
	private String num_cuenta;
	
	@ManyToOne 
	@JoinColumn (name="id")
	UserModel obj1;

	public Long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(String num_cuenta) {
		this.num_cuenta = num_cuenta;
	}
	
	

}
