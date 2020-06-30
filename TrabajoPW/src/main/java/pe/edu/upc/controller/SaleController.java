package pe.edu.upc.controller;

import java.awt.desktop.PrintFilesEvent;
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

import pe.edu.upc.entity.Sale;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.ISaleService;
import pe.edu.upc.serviceinterface.IUserService;

@Controller
@RequestMapping("/sales")
public class SaleController{
	private ISaleService sS;
	@Autowired
	private IProductService pS;
	@Autowired
	private IUserService uS;

	@GetMapping("/new")
	public String newSale(Model model)
	{
		model.addAttribute("listProducts", pS.list()); 
		model.addAttribute("listUsers", uS.list()); 
		model.addAttribute("sale",new Sale());

		return "sale/sale";	
	};

	@PostMapping("/save")
	public String saveSale(@Validated Sale sale, BindingResult result, Model model)
	{
		
		if(result.hasErrors()) {

			model.addAttribute("listProducts", pS.list()); 
			model.addAttribute("listUsers", uS.list()); 
			return "sale/sale";
		}else {
			System.out.println(sale.getQuantitySale());
			sS.insert(sale);
			System.out.println(sale);
			model.addAttribute("listSales",sS.list());
			model.addAttribute("mensaje","Registrado Correctamente");
			return "redirect:/sales/list";

			}
	}

	@GetMapping("/list")

	public String listSale(Model model) {
		try {
			model.addAttribute("sale",new Sale());
			model.addAttribute("listSales",sS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "sale/listSales";	
	}

	@RequestMapping("/delete/{id}")
	public String deleteSale(Model model, @PathVariable(value = "id") int id) {
		try {
			if ( id > 0) {
				pS.delete(id);	
			}
			model.addAttribute("listSales",sS.list());
			model.addAttribute("sale",new Sale());
			model.addAttribute("mensaje", "Se eliminó correctamente");
		}
			catch (Exception e) {
			model.addAttribute("sale", new Sale());
			
			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar un registro");
			model.addAttribute("listSales",sS.list());	
		}
		return "sale/listSales";
	}

	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Sale> objAr = sS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/sales/list";
		} else {

			model.addAttribute("listProducts", pS.list()); 
			model.addAttribute("listUsers", uS.list()); 
			model.addAttribute("sale", objAr.get());
			return "sale/sale";
		}
	}
}