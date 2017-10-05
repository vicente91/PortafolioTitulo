package com.SpringBoot.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoot.Interface.SpringBootRepository;
import com.SpringBoot.models.Alumno;
import com.SpringBoot.services.AlumnoService;

@Controller
public class MainController {
	
	@Autowired
	private AlumnoService alumService;
	

	@GetMapping(value = "/" )
	public String init(HttpServletRequest req) {
		req.setAttribute("alumnoObject", alumService.findAllALumnos());
		req.setAttribute("mode", "ALUMNO_VIEW" );
		return "index";
	}

	@GetMapping(value = "/updateAlumno" )
	public String init(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("alumno", alumService.findAlumno(id));
		req.setAttribute("mode", "ALUMNO_EDIT" );
		return "index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-mm-yyyy"), false));
	}
	
	
	 @PostMapping("/saveAlumno")
	public void save(@ModelAttribute Alumno alumno, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		
		alumService.save(alumno);
		req.setAttribute("alumnoObject", alumService.findAllALumnos());
		req.setAttribute("mode", "ALUMNO_VIEW" );
		resp.sendRedirect("/");
	}
	 
	 @GetMapping("/insertAlumno")
	 public String newAlumno(HttpServletRequest req) {
		 
		 req.setAttribute("mode", "ALUMNO_NEW");
		 return "index";
	 }
	 
	 @GetMapping("/borrarAlumno")
	 public String BorrarAlumno(@RequestParam long id, HttpServletRequest req)
		{
		 alumService.delete(id);
		 req.setAttribute("alumno", alumService.findAllALumnos());
		 req.setAttribute("mode", "ALUMNO_VIEW");
		 return "index";
	 }
	 
	 @GetMapping("/BuscarRut")
		public String searchRut(HttpServletRequest req) {		
			req.setAttribute("mode", "ALUMNO_FIND" );
			return "index";
		}
	
	
	 @GetMapping(value = "/traerAlumno" )
		public String TraeAlumno(@RequestParam int rut, HttpServletRequest req) {
		 req.setAttribute("alumnoObject", alumService.findAllALumnos());
		 
		 while(alumService!=null)
		 {
			 for(int i=0; i<alumService.findAllALumnos().size();i++)
			 {
				// alumService.)));
			 }
		 }
			req.setAttribute("mode", "ALUMNO_EDIT" );
			return "index";
		}
	
}
