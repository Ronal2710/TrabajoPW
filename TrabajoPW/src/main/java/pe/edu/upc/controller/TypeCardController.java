package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.TypeCard;
import pe.edu.upc.serviceinterface.ITypeCardService;

@Controller
@RequestMapping("/typeCard")
public class TypeCardController {
	
	@Autowired
	private ITypeCardService cS;

	@GetMapping("/new")
	public String newTypeCard(Model model) {
		model.addAttribute("typeCard", new TypeCard());
		return "typeCard/typeCard";
	};

	@PostMapping("/save")
	public String saveTypeCard(@Validated TypeCard typeCard, BindingResult result, Model model) {
		if (result.hasErrors())
			return "typeCard/typeCard";
		else {
			int rpta=cS.insert(typeCard);
			if(rpta>0) {
				
			model.addAttribute("mensaje","Ya existe el tipo de tarjeta");
			return "typeCard/listTypeCard";}
			else {
			
			cS.insert(typeCard);
			model.addAttribute("listTypeCard",cS.list());
			model.addAttribute("mensaje","Se registro Correctamente");
			return "typeCard/listTypeCard";
				}
		}
	}

	@GetMapping("/list")
	public String listTypeCard(Model model) {
		try {
			model.addAttribute("listTypeCard", cS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "typeCard/listTypeCard";
	}
}