package com.alura.foro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.topico.DatosRegistroTopico;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@PostMapping
	public void registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico) {
		System.out.println(datosRegistroTopico);
	}
}
