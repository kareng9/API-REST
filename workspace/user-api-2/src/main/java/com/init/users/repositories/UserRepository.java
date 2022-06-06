package com.init.users.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.init.users.models.CuentaModel;
import com.init.users.models.UserModel;

@Repository //indica que sera de tipo repositorio
public interface UserRepository extends CrudRepository<UserModel, Long> { //interface me indica que implementa ciertos metodos ya imprementados.
	public abstract Optional<UserModel> findById(Long id); 

}
