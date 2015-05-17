package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import modelos.Equipos;
import modelos.Jugadores;
import modelos.Usuarios;

import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;  

import com.app.equipos.AdministracionEquipo;
import com.app.equipos.AdministracionEquipoImpl;

import formularios.formEquipo;
import formularios.formUsuario;
  
@Controller
public class EquipoController{
	
	@Autowired
	private AdministracionEquipo aei;
	
	@RequestMapping(value = "/nuevoEquipo", method = RequestMethod.POST)
	public ModelAndView  crearEquipo(HttpSession session, 
			@ModelAttribute("fAcceso") formEquipo request
			){
		//comprobar usuario / pass
		ModelAndView model = new ModelAndView("nuevoEquipo");
		aei = new AdministracionEquipoImpl();
		//fEquipo.
		model.addObject("equipo", request);
		return model;
	}

	@RequestMapping(value = "/insertarEquipo", method = RequestMethod.POST)
	public ModelAndView  nuevoEquipo(HttpSession session, 
			@ModelAttribute("fEquipo") formEquipo request
			){
		
		//comprobar usuario / pass
		ModelAndView model = null;
		aei = new AdministracionEquipoImpl();
		//Creamos equipo
		Equipos eq = new Equipos();
		eq.setEstadio(request.getEstadio());
		eq.setIdUsuarioFk(request.getIdUsuarioFk());
		eq.setNombre(request.getNombre());
		System.out.println(eq.getIdUsuarioFk());
		eq = aei.insertarEquipo(eq);
		if(eq == null || eq.getIdEquipo() == null || eq.getIdEquipo() <= 0 ){
			System.out.println("No se ha podido insertar nuevo Equipo");
			model = new ModelAndView("nuevoEquipo");
		}else{
			System.out.println("Se ha insertado correctamente");
			model = new ModelAndView("usuario");
		}
		
		//fEquipo.
		model.addObject("equipo", request);
		return model;
	}
	
	@RequestMapping(value = "/equipo", method = RequestMethod.POST)
	public ModelAndView  verEquipo(HttpSession session, 
			@ModelAttribute("fAcceso") formEquipo request
			){
		//comprobar usuario / pass
		ModelAndView model = new ModelAndView("equipo");
		aei = new AdministracionEquipoImpl();
		//fEquipo
		model.addObject("equipo", request);
		return model;
	}
	
	@RequestMapping(value = "/jugadores", method = RequestMethod.POST)
	public ModelAndView  verJugadores(HttpSession session, 
			@ModelAttribute("fAcceso") formEquipo request
			){
		//comprobar usuario / pass
		ModelAndView model = new ModelAndView("jugadores");
		aei = new AdministracionEquipoImpl();
		//fEquipo
		Equipos eq = aei.getEquipoId(request.getIdEquipo());
		
		List<Jugadores> lstJugador = aei.getJugadores(eq);
		model.addObject("equipo", request);
		return model;
	}
	
}
