package com.uca.capas.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Producto {
	//anotaciones de validación
	@Size(message="El nombre no debe tener mas de 15 caracteres", max = 15)
	@NotEmpty(message="Este campo no puede estar vacío") 
	private String nombre;
	
	@Size(message="El nombre no debe tener mas de 30 caracteres", max = 30)
	@NotEmpty(message="Este campo no puede estar vacío") 
	private String descripcion;
	
	@NotNull(message="El no puede estar vacío") 
	@Min(value= 0, message="El precio no debe ser negativo")
	private Double precio;
	
	@NotEmpty(message="El campo no puede estar vacío") 
	@Pattern(regexp="^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message="El formato debe ser dd/MM/aaaa")
	private String vencimiento;
	 
	 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	 
	 

}
