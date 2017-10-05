package com.SpringBoot.Interface;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.models.Alumno;

@Repository
public interface SpringBootRepository extends CrudRepository<Alumno, Long>{
	
	List<Alumno> findByRut(Integer rut);

}
