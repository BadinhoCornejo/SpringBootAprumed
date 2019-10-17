package com.aprumed.SpringBootAprumed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprumed.SpringBootAprumed.models.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Integer>{
	
	public Avatar findByUrl(String url);
}
