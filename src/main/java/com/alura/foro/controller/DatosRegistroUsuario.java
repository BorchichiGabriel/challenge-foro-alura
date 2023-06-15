package com.alura.foro.controller;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
		@NotBlank
		String usuario,
		@NotBlank
		String password) {

}
