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

import pe.edu.upc.entity.CategoryProduct;
import pe.edu.upc.entity.TypePayment;
import pe.edu.upc.serviceinterface.ITypePaymentService;

@Controller
@RequestMapping("/typePayment")
public class TypePaymentController {

	@Autowired
	private ITypePaymentService pS;

	@GetMapping("/new")
	public String newTypePayment(Model model) {
		model.addAttribute("typePayment", new TypePayment());
		return "typePayment/typePayment";

	};

	@PostMapping("/save")
	public String saveTypePayment(@Validated TypePayment typePayment, BindingResult result, Model model) {
		if (result.hasErrors())
			return "typePayment/typePayment";
		else {
			int rpta = pS.insert(typePayment);
			if (rpta > 0) {

				model.addAttribute("mensaje", "Ya existe el metodo de pago");
				return "typePayment/listTypePayment";
			} else {

				pS.insert(typePayment);
				model.addAttribute("listTypePayment", pS.list());
				model.addAttribute("mensaje", "Se registro Correctamente");
				return "typePayment/listTypePayment";

			}
		}

	}

	@GetMapping("/list")
	public String listTypePayment(Model model) {
		try {
			model.addAttribute("typePayment", new TypePayment());
			model.addAttribute("listTypePayment", pS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "typePayment/listTypePayment";
	}
	@RequestMapping("/delete/{id}")
	public String deleteTypePayment(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				pS.delete(id);
				model.addAttribute("listTypePayment", pS.list());
				model.addAttribute("typePayment", new TypePayment());
				model.addAttribute("mensaje", "Se eliminó correctamente");			
			}
			return "typePayment/listTypePayment";

		} catch (Exception e) {
			model.addAttribute("typePayment", new TypePayment());

			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar un tipo de pago ya relacionado");
			model.addAttribute("listTypePayment", pS.list());

			return "typePayment/listTypePayment";
		}
	}
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<TypePayment> objAr = pS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/typePayment/list";
		} else {

			model.addAttribute("typePayment", objAr.get());
			return "typePayment/typePayment";
		}
	}
	
	@RequestMapping("/search")
	public String searchTypePayment(Model model, @Validated TypePayment category) throws ParseException {
		List<TypePayment> listCategories;

		listCategories = pS.findNameTypePaymentFull(category.getNameTypePayment());
		if (listCategories.isEmpty()) {

			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listTypePayment", listCategories);
		return "typePayment/listTypePayment";

	}

}
