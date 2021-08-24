package com.devsuperior.workshop_mongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.workshop_mongo.models.dto.PostDTO;
import com.devsuperior.workshop_mongo.models.entities.Post;
import com.devsuperior.workshop_mongo.repositories.PostRepository;
import com.devsuperior.workshop_mongo.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public PostDTO findById(String id) {
		Post entity = getEntityById(id);
		return new PostDTO(entity);
	}

	private Post getEntityById(String id) {
		Optional<Post> result = repository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
	}
	
	public List<PostDTO> findAll(){
		List<Post> list = repository.findAll();
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
}
