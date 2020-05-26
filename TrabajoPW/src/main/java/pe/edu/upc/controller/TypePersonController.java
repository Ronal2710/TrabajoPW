package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.TypePerson;
import pe.edu.upc.serviceinterface.ITypePersonService;



@Controller
@RequestMapping("/typePerson")
public class TypePersonController {
	
	
	@Autowired
	private ITypePersonService pS;
	
	@GetMapping("/new")
	public String newPerson(Model model)
	{
		model.addAttribute("typePerson",new TypePerson());
		return "typePerson/typePerson";
		
	};
	
	@PostMapping("/save")
	public String savePerson(@Validated TypePerson type, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "typePerson/typePerson";
		else {
			pS.insert(type);
			model.addAttribute("listPersons",pS.list());
			return "typePerson/listPersons";
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
		return "typePerson/listPersons";
		
		
	}


}
