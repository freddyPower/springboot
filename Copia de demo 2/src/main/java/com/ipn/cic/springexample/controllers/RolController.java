package com.ipn.cic.springexample.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipn.cic.springexample.model.RolModel;
import com.ipn.cic.springexample.model.UserModel;
import com.ipn.cic.springexample.services.IRolService;

@Controller
@RequestMapping(path="/rol")
public class RolController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	@Qualifier("REAL")	
	IRolService rolService;
	
	@GetMapping(path = "/all")
	public ModelAndView findAll() {

		ModelAndView mav =  new ModelAndView("rol/allRol");
		List<RolModel> lista = rolService.getAll();	
		
		log.info( String.format("Se encontraron %d resultados", lista.size() ) );
				mav.addObject("rolList", lista);
				
		return mav;
	}
	
	@GetMapping(path="/editFormRol/{id}")
	public ModelAndView updateRol( @PathVariable("id") String id ) {
		
		RolModel rol = this.rolService.findById(id);				
		ModelAndView mav =  new ModelAndView("usr/edit_rol_form_thyme");
		mav.addObject("rol" , rol);
		
		return mav;
	}
	
	
	@GetMapping(path = "/newRol")
	public ModelAndView getnewRolView( @ModelAttribute(name="rol")  RolModel rol) {	
		ModelAndView mav =  new ModelAndView("rol/new_rol_form");	
		mav.addObject("user", new UserModel());
		return mav;
	}
	
	@PostMapping(path = "/newRolRequest")
	public String createNewRol( @ModelAttribute(name="rol")  RolModel rol ) {	
			
		rolService.save(rol);
		log.info("Se guardo  exitosamente el rol : " + rol.toString());
		
		return "redirect:/rol/all";
	}
	
	@GetMapping(path="/editForm/{id}")
	public ModelAndView getUpdateForm( @PathVariable("id") String id ) {
		
		RolModel rol = this.rolService.findById(id);				
		ModelAndView mav =  new ModelAndView("rol/edit_rol_form");
		mav.addObject("rol" , rol);
		
		return mav;
	}
	
	@PostMapping(path = "/updateRol")
	public String updateRol( @ModelAttribute(name="rol") RolModel rol ) {	
			
		rolService.update(rol);
		log.info("Se edito rol el usuario : " + rol.toString());
		
		return "redirect:/rol/all";
	}
	
	@GetMapping(path="/delete/{id}")
	public String delete( @PathVariable("id") String id ) {		
		RolModel rol = this.rolService.findById(id);	
		rolService.delete(rol);		
		return "redirect:/rol/all";
	}
	
}
