package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Estudiante;

public interface IEstudianteService {
	
	public void insertarEstudiante(Estudiante estudiante);
	
	public List<Estudiante> buscarTodos();

	
}
