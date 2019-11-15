package com.aprumed.SpringBootAprumed.services;

import com.aprumed.SpringBootAprumed.models.UserMain;
import com.aprumed.SpringBootAprumed.models.Usuario;
import com.aprumed.SpringBootAprumed.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario user = userRepo.findByEmail(username);

        if(user == null)
            throw new UsernameNotFoundException("User not found");

        return new UserMain(user);
    }

}
