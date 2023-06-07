package com.alura.foro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.topico.DatosActualizarTopico;
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
	public Page<DatosListadoTopico> listaTopicos(@PageableDefault(size = 10) Pageable paginacion){
		return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
	}
	
	@PutMapping
	@Transactional
	public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
		Topico topico  = topicoRepository.getReferenceById(datosActualizarTopico.id());
		topico.actualizarDatos(datosActualizarTopico);
	}
}
