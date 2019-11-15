package com.aprumed.SpringBootAprumed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Avatar;
import com.aprumed.SpringBootAprumed.repositories.AvatarRepository;

@Service
public class AvatarService {
	@Autowired
	AvatarRepository avatarRepo;
	
	public Avatar getAvatarByUrl(String url) {
		return avatarRepo.findByUrl(url);
	}

	public Avatar addAvatar(Avatar avatar){ return avatarRepo.save(avatar); }

	public Avatar getAvatarByName(String nombreAvatar){ return  avatarRepo.findByNombreAvatar(nombreAvatar); }
}
