package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.TypeCurrency;
import pe.edu.upc.serviceinterface.ITypeCurrencyService;

@Controller
@RequestMapping("/typeCurrency")
public class TypeCurrencyController {
	
	@Autowired
	private ITypeCurrencyService cS;
	
	@GetMapping("/new")
	public String newTypeCurrency(Model model)
	{
		model.addAttribute("typeCurrency",new TypeCurrency());
		return "typeCurrency/typeCurrency";
	};

	@PostMapping("/save")
	public String saveTypeCurrency(@Validated TypeCurrency type, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "typeCurrency/typeCurrency";
		else {
			cS.insert(type);
			model.addAttribute("listTypeCurrency", cS.list());
			return "typeCurrency/listTypeCurrency";
		}	
	}

	@GetMapping("/list")
	public String listTypeCurrency(Model model) {
		try {
			model.addAttribute("listTypeCurrency",cS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "typeCurrency/listTypeCurrency";		
	}
}
