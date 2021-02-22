package com.example.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.springbootmongodb.domain.Post;
import com.example.springbootmongodb.domain.User;
import com.example.springbootmongodb.dto.AuthorDTO;
import com.example.springbootmongodb.repository.PostRepository;
import com.example.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiation  implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		
		User kiiro = new User(null, "Kiiro Matos", "kiiro@gmail.com");
		User kimmi = new User(null, "Kimmi Matos", "kimmi@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(kiiro, kimmi, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2020"), "Partiu viagem", "Partiu Cancun, abraços!", new AuthorDTO(kiiro));
		Post post2 = new Post(null, sdf.parse("22/03/2020"), "Bom dia", "Acordei bem demais hoje", new AuthorDTO(kiiro));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
