package com.alura.foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.usuario.Usuario;
import com.alura.foro.usuario.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
		if(usuarioRepository.existsByUsuario(datosRegistroUsuario.usuario())) {
			throw new IllegalArgumentException("Ya existe un usuario con ese nombre");
		}
		usuarioRepository.save(new Usuario(datosRegistroUsuario));
	}
	
	
	
}
