package com.alura.foro.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(String titulo, String mensaje,LocalDateTime fechaCreacion,
		StatusTopico estatus, String autor, String curso) {
		
	public DatosListadoTopico(Topico topico) {
		this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
				topico.getEstatus(), topico.getCurso(), topico.getAutor());
	}

}
