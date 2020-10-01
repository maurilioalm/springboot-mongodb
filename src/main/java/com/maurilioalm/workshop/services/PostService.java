package com.maurilioalm.workshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurilioalm.workshop.domain.Post;
import com.maurilioalm.workshop.domain.User;
import com.maurilioalm.workshop.repository.PostRepository;
import com.maurilioalm.workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
