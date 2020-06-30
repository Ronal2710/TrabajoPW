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

import pe.edu.upc.entity.Brand;
import pe.edu.upc.serviceinterface.IBrandService;

@Controller
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	private IBrandService bS;
	
	@GetMapping("/new")
	public String newBrand(Model model)
	{
		model.addAttribute("brand",new Brand());
		return "brand/brand";
		
	};
	
	@PostMapping("/save")
	public String saveBrand(@Validated Brand brand, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "brand/brand";
		else {
			
			int rpta=bS.insert(brand);
			if(rpta>0) {
				
			model.addAttribute("mensaje","Categoria existe");
			return "brand/listBrands";}
			else {
			
			bS.insert(brand);
			model.addAttribute("listBrands",bS.list());
			model.addAttribute("mensaje","Se Registro Correctamente");
			return "brand/listBrands";
				}
			}
		
	}
	
	@GetMapping("/list")
	public String listBrand(Model model) {
		try {
			model.addAttribute("listBrands",bS.list());
			model.addAttribute("brand", new Brand());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "brand/listBrands";	
	}

	@RequestMapping("/delete/{id}")
	public String deleteBrand(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				bS.delete(id);
				model.addAttribute("listBrands", bS.list());
				model.addAttribute("brand", new Brand());
				model.addAttribute("mensaje", "Se eliminó correctamente");

			}
			return "brand/listBrands";

		} catch (Exception e) {
			model.addAttribute("brand", new Brand());

			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar ");
			model.addAttribute("listBrands", bS.list());

			return "brand/listBrands";
		}

	}

	@RequestMapping("/search")
	public String searchBrand(Model model, @Validated Brand brand) throws ParseException {
		List<Brand> listBrands;

		listBrands = bS.findNameBrandFull(brand.getNameBrand());
		if (listBrands.isEmpty()) {

			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listBrands", listBrands);
		return "brand/listBrands";

	}
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Brand> objAr = bS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/brands/list";
		} else {
			
			model.addAttribute("brand", objAr.get());
			model.addAttribute("mensaje", "Se Actualizo Correctamente");
			return "brand/brand";
		}
	}
	
}
