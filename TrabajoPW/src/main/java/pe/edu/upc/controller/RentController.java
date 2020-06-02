package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Rent;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.IRentService;

@Controller
@RequestMapping("/rents")
public class RentController {
	
	@Autowired
	private IRentService rS;
	@Autowired
	private IProductService pS;
	
	@GetMapping("/new")
	public String newRent(Model model)
	{
		model.addAttribute("listProducts", pS.list()); 
		model.addAttribute("rent",new Rent());
	
		return "rent/rent";	
	};
	
	@PostMapping("/save")
	public String saveRent(@Validated Rent rent, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "rent/rent";
		else {

			rS.insert(rent);
			model.addAttribute("listRents",rS.list());
			model.addAttribute("mensaje","Registered Correctly");
			return "rent/listRents";
				
			}
	}

	@GetMapping("/list")
	public String listRent(Model model) {
		try {
			model.addAttribute("listRents",rS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "rent/listRents";	
	}
}
