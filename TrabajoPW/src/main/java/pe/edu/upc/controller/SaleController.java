package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Sale;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.ISaleService;

@Controller
@RequestMapping("/sales")
public class SaleController {
	
	@Autowired
	private ISaleService sS;
	@Autowired
	private IProductService pS;
	
	@GetMapping("/new")
	public String newProduct(Model model)
	{
		model.addAttribute("listProducts", pS.list()); 
		model.addAttribute("sale",new Sale());
	
		return "sale/sale";	
	};
	
	@PostMapping("/save")
	public String saveProduct(@Validated Sale sale, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "sale/sale";
		else {

			sS.insert(sale);
			model.addAttribute("listSales",sS.list());
			model.addAttribute("mensaje","Registered Correctly");
			return "sale/listSales";
				
			}
	}

	@GetMapping("/list")
	public String listProduct(Model model) {
		try {
			model.addAttribute("listSales",sS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "sale/listSales";	
	}

}
