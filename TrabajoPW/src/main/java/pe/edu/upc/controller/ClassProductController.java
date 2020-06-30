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

import pe.edu.upc.entity.ClassProduct;
import pe.edu.upc.serviceinterface.IClassProductService;

@Controller
@RequestMapping("/classProduct")
public class ClassProductController {
	
	@Autowired
	private IClassProductService cS;
	
	@GetMapping("/new")
	public String newClassProduct(Model model)
	{
		model.addAttribute("classProduct",new ClassProduct());
		return "classProduct/classProduct";
		
	};
	
	@PostMapping("/save")
	public String saveClassProduct(@Validated ClassProduct classpro, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "classProduct/classProduct";
		else {
			
			int rpta=cS.insert(classpro);
			if(rpta>0) {
				
			model.addAttribute("mensaje","Categoria existe");
			return "classProduct/classProduct";}
			else {
			
			cS.insert(classpro);
			model.addAttribute("listClassProduct",cS.list());
			model.addAttribute("mensaje","Se Registro Correctamente");
			return "classProduct/listClassProduct";
				}
			}

	}
	
	@GetMapping("/list")
	public String listClassProduct(Model model) {
		try {
			model.addAttribute("listClassProduct",cS.list());
			model.addAttribute("classProduct", new ClassProduct());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "classProduct/listClassProduct";
		
		
	}

	@RequestMapping("/delete/{id}")
	public String deleteClassProduct(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				cS.delete(id);
				model.addAttribute("listClassProduct", cS.list());
				model.addAttribute("classProduct", new ClassProduct());
				model.addAttribute("mensaje", "Se eliminó correctamente");

			}
			return "classProduct/listClassProduct";

		} catch (Exception e) {
			model.addAttribute("classProduct", new ClassProduct());
			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar ");
			model.addAttribute("listClassProduct", cS.list());

			return "classProduct/listClassProduct";
		}

	}

	@RequestMapping("/search")
	public String searchClassProduct(Model model, @Validated ClassProduct classpro) throws ParseException {
		List<ClassProduct> listClassProduct;

		listClassProduct = cS.findNameClassProductFull(classpro.getNameClassProduct());
		if (listClassProduct.isEmpty()) {

			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listClassProduct", listClassProduct);
		return "classProduct/listClassProduct";
	}
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<ClassProduct> objAr = cS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/classProduct/list";
		} else {
			model.addAttribute("classProduct", objAr.get());
			model.addAttribute("mensaje", "Se Actualizo Correctamente");
			return "classProduct/classProduct";
		}
	}
}
