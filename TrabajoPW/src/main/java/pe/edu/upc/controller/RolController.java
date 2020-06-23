package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Rol;
import pe.edu.upc.entity.User;
import pe.edu.upc.serviceinterface.IRolService;
import pe.edu.upc.serviceinterface.IUserService;



@Controller
@RequestMapping("/roles")
@Secured("ROLE_ADMIN")
public class RolController {
	@Autowired
	private IRolService rS;
	@Autowired
	private IUserService uS;

	@GetMapping("/new")
	public String newRole(Model model) {
		model.addAttribute("role", new Rol());
		model.addAttribute("listUsers", uS.list());
		return "rol/role";
	}

	@PostMapping("/save")
	public String saveRole(@Validated Rol role, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "role/role";
		} else {
			rS.insert(role);
			model.addAttribute("listRoles", rS.list());
			return "rol/listRoles";

		}
	}

	@GetMapping("/list")
	public String listRole(Model model) {
		try {
			model.addAttribute("listRoles", rS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "rol/listRoles";

	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				uS.delete(id);
			
				model.addAttribute("user", new User());
				model.addAttribute("mensaje", "Se eliminó correctamente");

			}
			return "user/listUsers";

		} catch (Exception e) {
			model.addAttribute("user", new User());

			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar usuario");
			model.addAttribute("user", uS.list());

			return "user/listUsers";
		}

	}

}
