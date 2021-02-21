package com.example.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmongodb.domain.User;
import com.example.springbootmongodb.dto.UserDTO;
import com.example.springbootmongodb.repository.UserRepository;
import com.example.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; // repo é um mecanismo de injeção de dependência do spring //
	
	public List<User> findAll() {
		return repo.findAll(); // findAll para retornar os usuários do banco de dados //
		
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
