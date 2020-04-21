package com.mrsisa.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.entity.Authority;
import com.mrsisa.repository.AuthorityRepository;


@Service
public class AuthorityService extends CRUDService<Authority, Integer>{
	
	@Autowired
	public AuthorityService(AuthorityRepository repo) {
		super(repo);
	}
	
	public Authority findByName(String name) {
		Authority ret = null;
		Optional<Authority> authority = ((AuthorityRepository)repo).findByName(name);
		if(authority.isPresent()) {
			ret = authority.get();
		}
		else {
			Authority auth = new Authority();
			auth.setName(name);
			ret = save(auth);
		}
		return ret;
	}

}
