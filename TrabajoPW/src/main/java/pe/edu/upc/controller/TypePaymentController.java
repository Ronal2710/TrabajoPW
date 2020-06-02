package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
			model.addAttribute("listTypePayment", pS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "typePayment/listTypePayment";
	}
}
