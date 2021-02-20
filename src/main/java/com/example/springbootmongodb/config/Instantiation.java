package com.example.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.springbootmongodb.domain.User;
import com.example.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiation  implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		userRepository.deleteAll();
		
		User kiiro = new User(null, "Kiiro Matos", "kiiro@gmail.com");
		User kimmi = new User(null, "Kimmi Matos", "kimmi@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(kiiro, kimmi, bob));
	}

}
