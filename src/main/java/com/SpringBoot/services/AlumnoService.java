package com.SpringBoot.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Interface.SpringBootRepository;
import com.SpringBoot.models.Alumno;



@Service
public class AlumnoService {

	@Autowired
	private SpringBootRepository sbRepository;
	
	public Collection<Alumno> findAllALumnos(){
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		for(Alumno alumno : sbRepository.findAll()) {
			alumnos.add(alumno);
			System.out.println(alumno.getApellido());
		}
		return alumnos;
	}
	
	public void delete(long id) {
		sbRepository.delete(id);
	}
	
	public Alumno findAlumno(long id)
	{
		return sbRepository.findOne(id);
	}
	

	
	public void save(Alumno alumno)
	{
		sbRepository.save(alumno);
	}
	
}
