package com.init.users.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Indica que es un modelo real
@Table (name = "usuario") //Dar el nombre a la tabla*/
public class UserModel extends PersonaModel{
	
	//Hereda todo menos el id, es propio de cada entidad
	
	@Id //para que la bd sepa que es un Id.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false) //Es un Id único, autoincrementable, no nulo
	private Long id;
	
	@OneToMany (cascade = CascadeType.ALL)
	private List<CuentaModel> obj2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CuentaModel> getObj2() {
		return obj2;
	}

	public void setObj2(List<CuentaModel> obj2) {
		this.obj2 = obj2;
	}

	
}

