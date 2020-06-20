package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
				
			model.addAttribute("mensaje","Ya existe esta categoria");
			return "categoryProduct/listCategories";}
			else {
			
			cS.insert(category);
			model.addAttribute("listCategories",cS.list());
			model.addAttribute("mensaje","Registered Correctly");
			return "categoryProduct/listCategories";
				}
			}
		
	}
	
	@GetMapping("/list")
	public String listCategory(Model model) {
		try {
			model.addAttribute("listCategories",cS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "categoryProduct/listCategories";
		
		
	}


}
