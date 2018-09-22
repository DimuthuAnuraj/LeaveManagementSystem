package com.sgic.myleave.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.myleave.entity.User;

	
@RestController
public class UserController {
	private List <User> users = new ArrayList<>();
	@GetMapping("/users")
	public ResponseEntity<User> getUser() {
//		User user = new User();
//		user.setId("U01");
//		user.setName("Maleen");
//		user.setPosition("Engineer");
		
		ResponseEntity<User> response = new ResponseEntity<>(users.get(0),HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/all-users")
	public ResponseEntity<List<User>> getAllUsers() {
		ResponseEntity<List<User>> response = new ResponseEntity<>(users,HttpStatus.OK);
		return response;
	}

	@PostMapping("/users")
		public HttpStatus createuser(@RequestBody User user) {
//			System.out.println(user.getName());
			users.add(user);
			
			return HttpStatus.CREATED;
		}
	@PutMapping("/users/{id}")
	public HttpStatus editUser(@RequestBody User user, @PathVariable("id") String id) {
		for(int i=0;i<users.size();i++) {
			String userId = users.get(i).getId();
			if(userId.equals(id)) {
				users.set(i, user);
				break;
			}
		}
		return HttpStatus.ACCEPTED;
	}
	@DeleteMapping("/users/{myid}")
	public HttpStatus deleteUser(@PathVariable("myid") String id) {
		for(int i=0;i<users.size();i++) {
			String oldId = users.get(i).getId();
			if(oldId.equals(id)) {
				users.remove(i);
				break;
			}
		}
		return HttpStatus.OK;
	}
}
