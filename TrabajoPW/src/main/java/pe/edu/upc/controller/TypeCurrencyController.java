package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
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
			int rpta=cS.insert(type);
			if(rpta>0) {
				
			model.addAttribute("mensaje","Ya existe el tipo de moneda");
			return "typeCurrency/listTypeCurrency";}
			else {
			
			cS.insert(type);
			model.addAttribute("listTypeCurrency",cS.list());
			model.addAttribute("mensaje","Se registro Correctamente");
			return "typeCurrency/listTypeCurrency";
				}
		}	
	}
	@RequestMapping("/delete/{id}")
	public String deleteTypeCurrency(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				cS.delete(id);
				model.addAttribute("listTypeCurrency", cS.list());
				model.addAttribute("typeCurrency", new TypeCurrency());
				model.addAttribute("mensaje", "Se eliminó correctamente");

			}
			return "typeCurrency/listTypeCurrency";

		} catch (Exception e) {
			model.addAttribute("typeCurrency", new TypeCurrency());

			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar un tipo de moneda ya relacionado");
			model.addAttribute("listTypeCurrency", cS.list());

			return "TypeCurrency/listTypeCurrency";
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
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<TypeCurrency> objAr = cS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/typeCurrency/list";
		} else {

			model.addAttribute("typeCurrency", objAr.get());
			return "typeCurrency/typeCurrency";
		}
	}
	
	@RequestMapping("/search")
	public String searchTypeCurrency(Model model, @Validated TypeCurrency typeCurrency) throws ParseException {
		List<TypeCurrency> listTypeCurrencys;
		model.addAttribute("typeCurrency", new TypeCurrency());
		listTypeCurrencys = cS.search(typeCurrency.getNameTypeCurrency());
		if (listTypeCurrencys.isEmpty()) {
			
			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listTypeCurrency", listTypeCurrencys);
		return "typeCurrency/listTypeCurrency";
	}
}
