package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Estudiante;

public interface IEstudianteRepository {
	
	public void guardarEstudiante(Estudiante estudiante);
	
	
	public List<Estudiante> buscarTodos();

}
