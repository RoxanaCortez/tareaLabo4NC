package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Producto;
import com.uca.capas.domain.Robot;

@Controller
public class MainController {
	
	@RequestMapping("/producto")	//mapeo a producto
	public ModelAndView initMain() {	
		Producto producto = new Producto();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("producto", producto);
		mav.setViewName("index");
		return mav;
	}
	
	//Recibiendo las anotaciones de validación con BindingResult
	@RequestMapping("/formProducto")
	public ModelAndView formProducto(@Valid @ModelAttribute Producto producto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) { 	//si hay errores
			mav.setViewName("index");	//seteamos pag index con errores incluidos
		}
		else {	//si no hay errores nos dirige pag robot para saber si somos robot o no
			Robot robot = new Robot();
			mav.addObject("robot", robot);
			mav.setViewName("robot");
		}
		return mav;
	}
	
	@RequestMapping("/seguridad") 	//para validar los errores que nosotros definimos en nuestro objeto robot 
	public ModelAndView formSeguridad(@Valid @ModelAttribute Robot robot, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {	//si hay error nos muestra el error en la msima pagina robot
			mav.setViewName("robot");
		}
		else {
			mav.setViewName("exito"); 	//sino hay error no muestra mensaje de exito
		}
		return mav;
	}
	
}
