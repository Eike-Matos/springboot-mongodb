package com.example.springbootmongodb.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongodb.domain.User;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User kiiro = new User("1", "Kiiro", "kiiro@gmail.com");
		User kimmi = new User("2", "Kimmi", "kimmi@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(kiiro, kimmi));
		return ResponseEntity.ok().body(list);
	}


}
