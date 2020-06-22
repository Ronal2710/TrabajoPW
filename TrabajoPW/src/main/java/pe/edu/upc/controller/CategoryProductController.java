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

import pe.edu.upc.serviceinterface.ICategoryProductService;



@Controller
@RequestMapping("/categoriesProduct")
public class CategoryProductController {
	
	
	@Autowired
	private ICategoryProductService cS;
	
	@GetMapping("/new")
	public String newCategory(Model model)
	{
		model.addAttribute("categoryProduct",new CategoryProduct());
		return "categoryProduct/categoryProduct";
		
	};
	
	@PostMapping("/save")
	public String saveCategory(@Validated CategoryProduct category, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "categoryProduct/categoryProduct";
		else {
			
			int rpta=cS.insert(category);
			if(rpta>0) {
				
			model.addAttribute("mensaje","Categoria existe");
			return "categoryProduct/listCategories";}
			else {
			
			cS.insert(category);
			model.addAttribute("listCategories",cS.list());
			model.addAttribute("mensaje","Se Registro Correctamente");
			return "categoryProduct/listCategories";
				}
			}
		
	}
	
	@GetMapping("/list")
	public String listCategory(Model model) {
		try {
			model.addAttribute("listCategories",cS.list());
			model.addAttribute("categoryProduct", new CategoryProduct());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "categoryProduct/listCategories";
		
		
	}

	@RequestMapping("/delete/{id}")
	public String deleteCategory(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				cS.delete(id);
				model.addAttribute("listCategories", cS.list());
				model.addAttribute("categoryProduct", new CategoryProduct());
				model.addAttribute("mensaje", "Se eliminó correctamente");

			}
			return "categoryProduct/listCategories";

		} catch (Exception e) {
			model.addAttribute("categoryProduct", new CategoryProduct());

			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar ");
			model.addAttribute("listCategories", cS.list());

			return "categoryProduct/listCategories";
		}

	}

	@RequestMapping("/search")
	public String searchCategories(Model model, @Validated CategoryProduct category) throws ParseException {
		List<CategoryProduct> listCategories;

		listCategories = cS.findNameCategoryProductFull(category.getNameCategoryProduct());
		if (listCategories.isEmpty()) {

			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listCategories", listCategories);
		return "categoryProduct/listCategories";

	}
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<CategoryProduct> objAr = cS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/categoriesProduct/list";
		} else {
			
			model.addAttribute("categoryProduct", objAr.get());
			model.addAttribute("mensaje", "Se Actualizo Correctamente");
			return "categoryProduct/categoryProduct";
		}
	}

}
