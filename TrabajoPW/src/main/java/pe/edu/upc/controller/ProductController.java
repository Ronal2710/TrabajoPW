package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Product;
import pe.edu.upc.serviceinterface.ICategoryProductService;
import pe.edu.upc.serviceinterface.IProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private IProductService pS;
	@Autowired
	private ICategoryProductService cS;
	
	@GetMapping("/new")
	public String newProduct(Model model)
	{
		model.addAttribute("listCategories", cS.list()); 
		model.addAttribute("product",new Product());
	
		return "product/product";	
	};
	
	@PostMapping("/save")
	public String saveProduct(@Validated Product Product, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "product/product";
		else {
			
			int rpta=pS.insert(Product);
			if(rpta>0) {
				
			model.addAttribute("mensaje","Product exist");
			return "product/product";}
			else {
			
			pS.insert(Product);
			model.addAttribute("listProducts",pS.list());
			model.addAttribute("mensaje","Registered Correctly");
			return "product/listProducts";
				}
			}
		}

	@GetMapping("/list")
	public String listProduct(Model model) {
		try {
			model.addAttribute("listProducts",pS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "product/listProducts";	
	}


}
