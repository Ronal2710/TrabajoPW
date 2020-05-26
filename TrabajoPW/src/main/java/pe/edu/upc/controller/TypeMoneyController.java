package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.TypeMoney;
import pe.edu.upc.serviceinterface.ITypeMoneyService;

@Controller
@RequestMapping("/typeMoney")
public class TypeMoneyController {
	
	@Autowired
	private ITypeMoneyService cS;
	
	@GetMapping("/new")
	public String newTypeMoney(Model model)
	{
		model.addAttribute("typeMoney",new TypeMoney());
		return "typeMoney/typeMoney";
	};

	@PostMapping("/save")
	public String saveTypeMoney(@Validated TypeMoney type, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "typeMoney/typeMoney";
		else {
			cS.insert(type);
			model.addAttribute("listTypeMoney", cS.list());
			return "typeMoney/listTypeMoney";
		}	
	}

	@GetMapping("/list")
	public String listTypeMoney(Model model) {
		try {
			model.addAttribute("listTypeMoney",cS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "typeMoney/listTypeMoney";		
	}
}
