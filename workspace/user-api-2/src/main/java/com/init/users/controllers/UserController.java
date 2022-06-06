package com.init.users.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.users.models.CuentaModel;
import com.init.users.models.UserModel;
import com.init.users.repositories.UserRepository;
import com.init.users.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping()
	public ArrayList<UserModel> obtenerUsuarios(){
		return userService.obtenerUsuarios();
	}
	
	@PostMapping() //Guardar usuario - regresa el usuario con el id
	public UserModel guardarUsuario(@RequestBody UserModel user) {
		return this.userService.guardarUsuario(user);
	}
	@GetMapping(path = "/{id}")
	public Optional<UserModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.userService.obtenerPorId(id);
	}
	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.userService.eliminarUsuario(id);
		if(ok) {
			return "Se elimino el usuario de id: " + id;
		}else {
			return "No se pudo eliminar el usuario de id: " +id;
		}
	}

	@GetMapping(path = "/obtenerCuentas/{id}")
	public Optional<List<CuentaModel>> obtenerCuentasPorId(@PathVariable("id") Long id){
		return this.userService.obtenerCuentas(id);
	}
}
