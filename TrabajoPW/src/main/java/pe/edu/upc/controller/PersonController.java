package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Person;
import pe.edu.upc.serviceinterface.IPersonService;
import pe.edu.upc.serviceinterface.ITypeUserService;


@Controller
@RequestMapping("/persons")
public class PersonController {
	
	
	@Autowired
	private IPersonService pS;
	@Autowired
	private ITypeUserService tS;
	
	@GetMapping("/new")
	public String newPerson(Model model)
	{
		model.addAttribute("listTypeUser", tS.list());
		model.addAttribute("person",new Person());
		return "person/person";
		
	};
	
	@PostMapping("/save")
	public String savePerson(@Validated Person person, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "person/person";
		else {
			
			int rpta= pS.insert(person);
			if(rpta>0) 
			{
				
			model.addAttribute("mensaje","Ya existe la Persona ");
			return "person/listPersons";}
			else {
			
			pS.insert(person);
			model.addAttribute("listPersons",pS.list());
			model.addAttribute("mensaje","Se registro Correctamente");
			return "person/listPersons";
				}
			}
		
	}
	
	@GetMapping("/list")
	public String listPerson(Model model) {
		try {
			model.addAttribute("listPersons",pS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "person/listPersons";
		
		
	}


}