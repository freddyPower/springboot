package com.ipn.cic.springexample.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipn.cic.springexample.model.UserModel;
import com.ipn.cic.springexample.services.IUserService;

//Falta otra anotacion context
@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	private final Log log = LogFactory.getLog(this.getClass());

	@Autowired
	@Qualifier("REAL")
	private IUserService userService;

	@GetMapping(path = "/all") // Peticiones tipo Get versiones con spring boot, version optimizada.
    //@PostMapping(path = "/all") //Peticiones tipo post
	// @RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView findAll() {

		ModelAndView mav =  new ModelAndView("usr/allUsers");
		List<UserModel> lista = userService.getAll();
		log.info( String.format("Se encontraron %d resultados", lista.size() ) );
				mav.addObject("usrList", lista);
				
		return mav;
	}
	
	@GetMapping(path="/newUserForm")
	public ModelAndView getNewUserForm() {		
		ModelAndView mav =  new ModelAndView("usr/new_user_form");	
		return mav;
	}
	
	@PostMapping(path = "/newUser")
	public String createNew( HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String lastName =  request.getParameter("lastName");
		String secondLastName =  request.getParameter("secondLastName");
		String age = request.getParameter("age");
		//int edad =  Integer.parseInt(age);
		
		UserModel usr =  new UserModel(name , lastName , secondLastName );		
		userService.save(usr);
		
		return "redirect:/user/all";
	}
	
	@PostMapping(path = "/newUser2")
	public String createNew2( 
		
		@RequestParam(name = "name" , required = true) String name,
		@RequestParam(name = "lastName" ) String lastName,
		@RequestParam(name = "secondLastName" ) String secondLastName,
		@RequestParam(name = "age" , required=false , defaultValue= "15" ) int age ) {
		
		UserModel usr =  new UserModel(name , lastName , secondLastName , age);		
		userService.save(usr);
		
		return "redirect:/user/all";
	}
	
	@PostMapping(path = "/newUser3")
	public String createNew3( UserModel usr ) {
		
			
		userService.save(usr);
		log.info("Se guardo  exitosamente el usuario : " + usr.toString());
		
		return "redirect:/user/all";
	}
	
	@PostMapping(path = "/newUser4")
	public String createNew4(@Validated UserModel usr ) {	
			
		userService.save(usr);
		log.info("Se guardo  exitosamente el usuario : " + usr.toString());
		
		return "redirect:/user/all";
	}
	
	@GetMapping(path="/newUserFormThyme")
	public ModelAndView getNewUserFormThyme() {		
		ModelAndView mav =  new ModelAndView("usr/new_user_form_thyme");	
		mav.addObject("user", new UserModel());
		return mav;
	}
	
	@PostMapping(path = "/newUser5")
	public String createNew5( @ModelAttribute(name="user")  UserModel usr ) {	
			
		userService.save(usr);
		log.info("Se guardo  exitosamente el usuario : " + usr.toString());
		
		return "redirect:/user/all";
	}
	
	@GetMapping(path="/editForm/{id}")
	public ModelAndView updateUser( @PathVariable("id") int id ) {
		
		UserModel user = this.userService.findById(id);				
		ModelAndView mav =  new ModelAndView("usr/edit_user_form_thyme");
		mav.addObject("user" , user);
		
		return mav;
	}
	
	@PostMapping(path = "/updateUser")
	public String updateUser( @ModelAttribute(name="user")  UserModel usr ) {	
			
		userService.update(usr);
		log.info("Se edito exitosamente el usuario : " + usr.toString());
		
		return "redirect:/user/all";
	}
	
	@GetMapping(path="/delete/{id}")
	public String delete( @PathVariable("id") int id ) {		
		UserModel user = this.userService.findById(id);	
		userService.delete(user);
		
		return "redirect:/user/all";
	}
	
	
	@GetMapping(path="/find/{name}")
	public String findByName( @PathVariable("name") String name ) {		
		
		UserModel user = this.userService.findByName(name);	
		log.info("RESULTADO EXACTO: " + user);
		
		
		UserModel user2 = this.userService.findByNameContains(name);	
		log.info("RESULTADO POR LIKE"+ user2) ;
		
		
		
		return "redirect:/user/all";
	}
	

}
