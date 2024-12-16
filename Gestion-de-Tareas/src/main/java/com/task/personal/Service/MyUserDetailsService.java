package com.task.personal.Service;

import com.task.personal.Entity.UsuarioEntity;
import com.task.personal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByNickusuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(usuario.getNickusuario(), usuario.getPassword(), new ArrayList<>());
    }
}