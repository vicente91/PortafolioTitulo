package com.SpringBoot.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="Alumno")
public class Alumno implements Serializable{

	private static final long serialVersionUID=1L;
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_alumno")
	private long Id;
	@Column(name="rut_alumno")
	private int rut;
	@Column(name="dv_alumno")
	private char dv;
	@Column(name="nombre_alumno")
	private String nombre;
	@Column(name="apellido_alumno")
	private String apellido;
	@Column(name="fecha_nacimiento_alumno")
	private Date fechNac;
	
		
	public long getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public char getDv() {
		return dv;
	}
	public void setDv(char dv) {
		this.dv = dv;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechNac() {
		return fechNac;
	}
	public void setFechNac(Date fechNac) {
		this.fechNac = fechNac;
	}
	
	
}
