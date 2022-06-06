package com.init.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.init.users.models.CuentaModel;
import com.init.users.models.UserModel;
import com.init.users.repositories.UserRepository;

@Service
public class UserService {
	@Autowired //No hace falta instanciar xq spring sabe que ya existe una y como usarla
	UserRepository userRepository;
	
	public ArrayList<UserModel> obtenerUsuarios(){
		return (ArrayList<UserModel>) userRepository.findAll();
	}
	public UserModel guardarUsuario(UserModel user) {
		return userRepository.save(user);
	}
	public Optional<UserModel> obtenerPorId(Long id) {
		return userRepository.findById(id);
	}
	public boolean eliminarUsuario(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		}catch (Exception err) {
			return false;
		}
	}
	
	public Optional <List<CuentaModel>> obtenerCuentas(Long id){


		try {
			 return Optional.ofNullable(userRepository.findById(id).get().getObj2());
		}catch(Exception err) {
			return null;
			
		}
	}
}
