package com.init.users.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.init.users.dao.UsersDAO;
import com.init.users.entitys.User;

@RestController	//Dice que esta clase va a ser servicio REST
@RequestMapping("users") //En que URL se va a exponer este servicio o metodos de esta clase
public class UsersREST {
	
	@Autowired  //Le decimos que inyecte un objeto real
	private UsersDAO userDAO;
	
	@GetMapping
	public ResponseEntity<List<User>> getUser(){  //Regresar Objetos
		/*User user = new User();
		user.setId(1);
		user.setName("Camila");*/
		List<User> users =userDAO.findAll();
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(value="{userId}") //muestra en la siguiente ruta users/userId --> /users/1
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId){  //Regresar Objetos
		/*User user = new User();
		user.setId(1);
		user.setName("Camila");*/
		Optional<User> optionalUser = userDAO.findById(userId);
		if(optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	//Cambio createUser por create
	public ResponseEntity<User> create(@RequestBody User user){
		User newUser = userDAO.save(user);
		return ResponseEntity.ok(newUser);
	}
	
	@DeleteMapping(value="{userId}") //responde en /users pero usa DELETE
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId){
		userDAO.deleteById(userId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user){
		Optional<User> optionalUser = userDAO.findById(user.getId());
		if(optionalUser.isPresent()) {
			User updateUser = optionalUser.get();
			updateUser.setName(user.getName());
			userDAO.save(updateUser);
			return ResponseEntity.ok(updateUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Estan comentados los dos porque era solo una prueba
	//@GetMapping //Dice que este servicio va a estar disponible mediante el metodo GET
	//Como solo esta activo @GetMapping se espera que el servicio este expuesto en //localhost:8080 que es la ra??z
	//@RequestMapping(value="hello", method=RequestMethod.GET) //
	public String hello() {
		return "Hello World";
	}

}
