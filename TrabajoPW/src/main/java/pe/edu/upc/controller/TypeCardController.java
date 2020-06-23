package pe.edu.upc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
	
	@RequestMapping("/delete/{id}")
	public String deleteTypeCard(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				cS.delete(id);
				model.addAttribute("listTypeCard", cS.list());
				model.addAttribute("typeCard", new TypeCard());
				model.addAttribute("mensaje", "Se eliminó correctamente");
			}
			return "typeCard/listTypeCard";

		} catch (Exception e) {
			model.addAttribute("typeCard", new TypeCard());

			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar un tipo de tarjeta ya relacionado");
			model.addAttribute("listTypeCard", cS.list());

			return "typeCard/listTypeCard";
		}
	}
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<TypeCard> objAr = cS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/typeCard/list";
		} else {
			model.addAttribute("typeCard", objAr.get());
			return "typeCard/typeCard";
		}
	}
	
}