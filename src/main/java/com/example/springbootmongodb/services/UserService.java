package com.example.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmongodb.domain.User;
import com.example.springbootmongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; // repo é um mecanismo de injeção de dependência do spring //
	
	public List<User> findAll() {
		return repo.findAll(); // findAll para retornar os usuários do banco de dados //
		
	}

}
