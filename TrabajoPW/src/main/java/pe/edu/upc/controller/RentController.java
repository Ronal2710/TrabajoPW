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

import pe.edu.upc.entity.Rent;
import pe.edu.upc.entity.RentDetails;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.IRentDetailsService;
import pe.edu.upc.serviceinterface.IRentService;
import pe.edu.upc.serviceinterface.IUserService;



@Controller
@RequestMapping("/rents")
public class RentController {

	@Autowired
	private IRentService rS;

	@Autowired
	private IProductService pS;

	@Autowired
	private IRentDetailsService ideS;
	
	@Autowired
	private IUserService uS;
	
	

	
	@RequestMapping("/new")
	public String irRegistrar(Model model) {
		model.addAttribute("rent", new Rent());
		model.addAttribute("listUsers", uS.list());
		return "rent/rent";
	}



	@RequestMapping("/newproduct/{id}")
	public String irNewProduct(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		model.put("detail", new RentDetails());
		model.put("listProducts", pS.list());
	

		Rent objimp = rS.listarId(id);
		model.put("rent", objimp);

		return "rent/details/detailForm";
	}


	@RequestMapping("/list")
	public String listar(Map<String, Object> model) {
		model.put("listRents", rS.listar());
		return "rent/listRents";
	}

	@GetMapping("/detail/{id}")
	public String detailImportation(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {
		Rent imp = rS.listarId(id);

		if (imp == null) {
			flash.addFlashAttribute("error", "El Detalle no existe en la base de datos");
			return "rent/listRent"; 
		}
		model.put("rent", imp);
		model.put("titulo", "Detalle de Renta #" + imp.getIdRent());

		return "rent/details/listDetail"; 
	}

	@PostMapping("/save")
	public String saveOrder(@Valid Rent rent, Model model, SessionStatus status, BindingResult binRes) {
		Date requestday = new Date();
		try {
			rent.setRequestDate(requestday);
			rS.insert(rent);
			status.setComplete();
			model.addAttribute("success", "Orden Generada");
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect: /rents/new";
		}

		return "redirect:/rents/list";
	}

	@PostMapping("/saveproduct{id}")
	public String newProductXImportation(@PathVariable(value = "id") Long id, @Valid RentDetails importationdet,
			RedirectAttributes flash, BindingResult result, Model model, SessionStatus status) {
		Rent imp = rS.listarId(id);
		if (result.hasErrors()) {
			flash.addFlashAttribute("error", "El valor debe ser positivo");
			String cadena1 = "redirect:/rents/newproduct/" + id;
			return cadena1;
		}
		try {
			imp.addDetailRentation(importationdet);
			rS.insert(imp);
			status.isComplete();
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		String cadena = "redirect:/rents/detail/" + id;
		return cadena;
	}


	@RequestMapping("{idimp}/eliminardetail/{id}")
	public String eliminarDetalle(Map<String, Object> model, @PathVariable(value = "id") Long idet,
			@PathVariable(value = "idimp") Long idimp, RedirectAttributes flash) {
		try {
			if ( idet != null && idet > 0) {
				ideS.delete(idet);
				flash.addAttribute("mensaje", "Se eliminó correctamente");
				flash.addAttribute("mensaje1", "Se eliminó correctamente el id" + idet);
			} else
				return "redirect:/home";
		} catch (Exception e) {
			model.put("mensaje", "No se puede eliminar");
			model.put("error", e.getMessage());
		}
		String cadena = "redirect:/rents/detail/" + idimp;
		return cadena;
	}

}
