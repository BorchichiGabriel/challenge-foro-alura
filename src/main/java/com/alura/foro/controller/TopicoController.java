package com.alura.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.topico.DatosListadoTopico;
import com.alura.foro.topico.DatosRegistroTopico;
import com.alura.foro.topico.Topico;
import com.alura.foro.topico.TopicoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@PostMapping
	public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
		topicoRepository.save(new Topico(datosRegistroTopico));
	}
	
	@GetMapping
	public List<DatosListadoTopico> listaTopicos(){
		return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
	}
}
