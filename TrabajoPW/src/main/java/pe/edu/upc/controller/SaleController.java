package pe.edu.upc.controller;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Sale;
import pe.edu.upc.entity.SaleDetails;

import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.ISaleDetailsService;
import pe.edu.upc.serviceinterface.ISaleService;
import pe.edu.upc.serviceinterface.IUserService;



@Controller
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	private ISaleService sS;

	@Autowired
	private IProductService pS;

	@Autowired
	private ISaleDetailsService idsS;
	
	@Autowired
	private IUserService uS;
	
	
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reports";
	}
	
	
	@RequestMapping("/new")
	public String irRegistrar(Model model) {
		model.addAttribute("sale", new Sale());
		model.addAttribute("listUsers", uS.list());
		return "sale/sale";
	}



	@RequestMapping("/newproduct/{id}")
	public String irNewProduct(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		model.put("detail", new SaleDetails());
		model.put("listProducts", pS.list());
	

		Sale objimp = sS.listarId(id);
		model.put("sale", objimp);

		return "sale/details/detailForm";
	}


	@RequestMapping("/list")
	public String listar(Map<String, Object> model) {
		model.put("listSales", sS.listar());
		return "sale/listSales";
	}

	@GetMapping("/detail/{id}")
	public String detailImportation(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {
		Sale imp = sS.listarId(id);

		if (imp == null) {
			flash.addFlashAttribute("error", "El Detalle no existe en la base de datos");
			return "sale/listSale"; 
		}
		model.put("sale", imp);
		model.put("titulo", "Detalle de Venta #" + imp.getIdSale());

		return "sale/details/listDetail"; 
	}

	@PostMapping("/save")
	public String saveOrder(@Valid Sale Sale, Model model, SessionStatus status, BindingResult binRes) {
		Date requestday = new Date();
		try {
			Sale.setRequestDate(requestday);
			sS.insert(Sale);
			status.setComplete();
			model.addAttribute("success", "Orden Generada");
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect: /sales/new";
		}

		return "redirect:/sales/list";
	}

	@PostMapping("/saveproduct{id}")
	public String newProductXImportation(@PathVariable(value = "id") Long id, @Valid SaleDetails importationdet,
			RedirectAttributes flash, BindingResult result, Model model, SessionStatus status) {
		Sale imp = sS.listarId(id);
		if (result.hasErrors()) {
			flash.addFlashAttribute("error", "El valor debe ser positivo");
			String cadena1 = "redirect:/sales/newproduct/" + id;
			return cadena1;
		}
		try {
			imp.addDetailSaleation(importationdet);
			sS.insert(imp);
			status.isComplete();
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		String cadena = "redirect:/sales/detail/" + id;
		return cadena;
	}


	@RequestMapping("{idimp}/eliminardetail/{id}")
	public String eliminarDetalle(Map<String, Object> model, @PathVariable(value = "id") Long idet,
			@PathVariable(value = "idimp") Long idimp, RedirectAttributes flash) {
		try {
			if ( idet != null && idet > 0) {
				idsS.delete(idet);
				flash.addAttribute("mensaje", "Se eliminó correctamente");
				flash.addAttribute("mensaje1", "Se eliminó correctamente el id" + idet);
			} else
				return "redirect:/home";
		} catch (Exception e) {
			model.put("mensaje", "No se puede eliminar");
			model.put("error", e.getMessage());
		}
		String cadena = "redirect:/sales/detail/" + idimp;
		return cadena;
	}

}
