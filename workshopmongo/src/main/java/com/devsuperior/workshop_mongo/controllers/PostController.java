package com.devsuperior.workshop_mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.workshop_mongo.models.dto.PostDTO;
import com.devsuperior.workshop_mongo.models.dto.UserDTO;
import com.devsuperior.workshop_mongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostController {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id){
		PostDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll(){
		List<PostDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
