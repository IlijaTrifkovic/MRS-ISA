package com.mrsisa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
	Optional<Authority> findByName(String name);
	Optional<Authority> findById(Integer id);
}