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

import pe.edu.upc.entity.Rent;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.IRentService;
import pe.edu.upc.serviceinterface.IUserService;

@Controller
@RequestMapping("/rents")
public class RentController {
	
	@Autowired
	private IProductService pS;
	@Autowired
	private IRentService rS;
	@Autowired
	private IUserService uS;
	
	@GetMapping("/new")
	public String newRent(Model model)
	{
		model.addAttribute("listProducts", pS.list());
		model.addAttribute("listUsers", uS.list()); 
		model.addAttribute("rent",new Rent());	
	
		return "rent/rent";	
	};
	
	@PostMapping("/save")
	public String saveRent(@Validated Rent rent, BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			model.addAttribute("listProducts", pS.list());
			model.addAttribute("listUsers", uS.list()); 
			return "rent/rent";
		}
		
		else {
			System.out.println(rent);
			rS.insert(rent);
			model.addAttribute("listRents",rS.list());
			model.addAttribute("mensaje","Registrado Correctamente");
			return "redirect:/rents/list";
				
			}
	}

	@GetMapping("/list")
	public String listRent(Model model) {
		try {
			model.addAttribute("rent",new Rent());
			model.addAttribute("listRents",rS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "rent/listRents";	
	}
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Rent> objAr = rS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/rents/list";
		} else {
			model.addAttribute("listProducts", pS.list()); 
			model.addAttribute("listUsers", uS.list()); 
			model.addAttribute("rent", objAr.get());
			return "rent/rent";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteRent(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				pS.delete(id);
				model.addAttribute("listRents", rS.list());
				model.addAttribute("rent", new Rent());
				model.addAttribute("mensaje", "Se eliminó correctamente");
			}
			return "rent/listRents";

		} catch (Exception e) {
			model.addAttribute("rent", new Rent());

			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar un Rento relacionado");
			model.addAttribute("listRents", rS.list());

			return "rent/listRents";
		}

	}
}
