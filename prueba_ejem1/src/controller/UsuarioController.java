package controller;  
  
import javax.servlet.http.HttpSession;
  
import modelos.Usuarios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;  

import formularios.formUsuario;
  
@Controller
public class UsuarioController {  
   
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ModelAndView  homeUsuario(HttpSession session, 
			@ModelAttribute("fAcceso") formUsuario request
			){
		//comprobar usuario / pass
    	
		ModelAndView model = new ModelAndView("usuario");
		Usuarios us = new Usuarios();
		us.setUsuario(request.getUsuario());
		us.setPassword(request.getPassword());
 
		model.addObject("usuario", us);
		System.out.println("Le hemos dao bien...");
		return model;
	}
}  