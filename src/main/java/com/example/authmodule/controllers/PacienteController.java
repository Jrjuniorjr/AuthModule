package com.example.authmodule.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authmodule.models.Paciente;
import com.example.authmodule.services.PacienteService;


@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@PostMapping("/cadastrarPaciente")
	public ResponseEntity<?> criarPaciente(@RequestBody Paciente paciente) {
		return pacienteService.cadastrarPaciente(paciente);
	}
	
	@DeleteMapping("/removerPaciente/{id}")
	public ResponseEntity<?> removerPaciente(@PathVariable("id") int id){
		return pacienteService.removerPaciente(id);
	}

	@GetMapping("/listarPacientes/{id}")
	public ResponseEntity<?> listarPacientes(@PathVariable("id") int id) {
		return pacienteService.listarPacientes(id);
	}
	@GetMapping("/consultarPaciente/{id}")
	public ResponseEntity<?> consultarPaciente(@PathVariable int id) {
		return pacienteService.consultarPaciente(id);
	}
	@PutMapping("/editarPaciente")
	public ResponseEntity<?> editarPaciente(@RequestBody Paciente paciente) {
		return pacienteService.editarPaciente(paciente);

	}
	

}