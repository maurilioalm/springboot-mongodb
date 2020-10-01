package com.maurilioalm.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurilioalm.workshop.domain.User;
import com.maurilioalm.workshop.dto.UserDTO;
import com.maurilioalm.workshop.repository.UserRepository;
import com.maurilioalm.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

	public User update(User obj) {
		User obj2 = findById(obj.getId());
		updateData(obj2, obj);
		return repo.save(obj2);
	}

	private void updateData(User obj2, User obj) {
		obj2.setName(obj.getName());
		obj2.setEmail(obj.getEmail());
	}
}
