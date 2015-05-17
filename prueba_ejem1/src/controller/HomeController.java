package controller;

import javax.servlet.http.HttpSession;

import modelos.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;  

import com.app.usuarios.AdministracionUsuario;
import com.app.usuarios.AdministracionUsuarioImpl;

import formularios.formUsuario;
  
@Controller
public class HomeController{
	
	@Autowired
	private AdministracionUsuario aui;
	

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView  home(HttpSession session, 
			@ModelAttribute("fAcceso") formUsuario request
			){
		//comprobar usuario / pass
		ModelAndView model = null;
		Usuarios us = new Usuarios();
		us.setUsuario(request.getUsuario());
		us.setPassword(request.getPassword());
		
		aui = new AdministracionUsuarioImpl();
		us = aui.existeUsuarioPassword(us);
		if(us.getIdUsuario()!= null && us.getIdUsuario() > 0 ){
			model = new ModelAndView("usuario");
			model.addObject("usuario", us);
			session.setAttribute("usuario", true);
		}else{
			session.setAttribute("usuario", false);
			model = new ModelAndView("home");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/nuevoUsuario", method = RequestMethod.GET)
	public ModelAndView  nuevoUsuarioGet(HttpSession session//, 
			//@ModelAttribute("formularioUsuario") formUsuario request
			){
		
		System.out.println("Nuevo Usuario: GET");
		ModelAndView model = new ModelAndView("nuevoUsuario");
		
		return model;
	}
	
	@RequestMapping(value = "/nuevoUsuario", method = RequestMethod.POST)
	public ModelAndView  nuevoUsuario(HttpSession session, 
			@ModelAttribute("formularioUsuario") formUsuario request
			){
		
		System.out.println("Request Usuario: " + request.getUsuario());
		Usuarios us = new Usuarios( request.getNombre(), request.getApellidos(), request.getUsuario(), request.getPassword(),
				request.getDireccion(), 'V', -1);
		
		aui = new AdministracionUsuarioImpl();
		us = aui.insertarUsuario(us);
		
		ModelAndView model = new ModelAndView("aceptarNuevoUsuario");
 
		
		return model;
	}
	
	@RequestMapping(value = "/aceptarUsuario", method = RequestMethod.GET)
	public ModelAndView  aceptarNuevoUsuario(){
		ModelAndView model = new ModelAndView("nuevoUsuario");
 
		return model;
	}

}
