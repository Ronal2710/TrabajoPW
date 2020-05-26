package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.TypeUser;
import pe.edu.upc.serviceinterface.ITypeUserService;





@Controller
@RequestMapping("/typeUser")
public class TypeUserController {
	
	
	@Autowired
	private ITypeUserService cS;
	
	@GetMapping("/new")
	public String newTypeUser(Model model)
	{
		model.addAttribute("typeUser",new TypeUser());
		return "typeUser/typeUser";
		
	};
	
	@PostMapping("/save")
	public String saveCategory(@Validated TypeUser typeUser, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "typeUser/typeUser";
		else {
			cS.insert(typeUser);
			model.addAttribute("listTypeUser", cS.list());
			return "typeUser/listTypeUser";
		}
		
	}
	
	@GetMapping("/list")
	public String listCategory(Model model) {
		try {
			model.addAttribute("listTypeUser",cS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "typeUser/listTypeUser";
		
		
	}


}
