package pe.edu.upc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Product;
//import pe.edu.upc.entity.User;
import pe.edu.upc.serviceinterface.IUploadFileService;
import pe.edu.upc.serviceinterface.IUserService;
import pe.edu.upc.serviceinterface.ICategoryProductService;
import pe.edu.upc.serviceinterface.IProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private IProductService pS;
	@Autowired
	private ICategoryProductService cS;
	@Autowired
	private IUserService uS;
	@Autowired
	private IUploadFileService uploadFileService;
//	@Autowired
//	private User user;

	@GetMapping("/new")
	public String newProduct(Model model)
	{
		model.addAttribute("listCategories", cS.list()); 
		model.addAttribute("listUsers", uS.list()); 
		model.addAttribute("product",new Product());
		return "product/product";	
	};

	@PostMapping("/save")
	public String saveProduct(@Valid Product product, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listCategories", cS.list()); 
			model.addAttribute("listUsers", uS.list()); 
			return "product/product";
		} else {
			if (!foto.isEmpty()) {

				if (product.getIdProduct() > 0 && product.getFoto() != null && product.getFoto().length() > 0) {

					uploadFileService.delete(product.getFoto());
				}

				String uniqueFilename = null;
				try {
					uniqueFilename = uploadFileService.copy(foto);
				} catch (IOException e) {
					e.printStackTrace();
				}

				flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
				product.setFoto(uniqueFilename);
			}
			int rpta = pS.insert(product);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/product/product";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listProducts", pS.list());

		return "redirect:/products/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				pS.delete(id);
				model.addAttribute("listProducts", pS.list());
				model.addAttribute("product", new Product());
				model.addAttribute("mensaje", "Se eliminó correctamente");

			}
			return "product/listProducts";

		} catch (Exception e) {
			model.addAttribute("product", new Product());

			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede eliminar un producto relacionado");
			model.addAttribute("listProducts", pS.list());

			return "product/listProducts";
		}

	}
	
	@GetMapping("/list")
	public String listProduct(Model model) {
		try {
			model.addAttribute("product", new Product());
			model.addAttribute("listProducts", pS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "product/listProducts";	
	}

	@RequestMapping("/search")
	public String searchProducts(Model model, @Validated Product product) throws ParseException {
		List<Product> listProducts;
		model.addAttribute("product", new Product());
		listProducts = pS.search(product.getNameProduct());
		if (listProducts.isEmpty()) {

			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listProducts", listProducts);
		return "product/listProducts";

	}

	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Product> objAr = pS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/products/list";
		} else {
			model.addAttribute("listCategories", cS.list()); 
			model.addAttribute("listUsers", uS.list()); 
			model.addAttribute("product", objAr.get());
			return "product/product";
		}
	}

	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

	@GetMapping(value = "/view/{id}")
	public String ver(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash) {

		Optional<Product> product = pS.searchId(id);
		if (product == null) {
			flash.addFlashAttribute("error", "El Producto no existe en la base de datos");
			return "redirect:/products/list";
		}

		model.addAttribute("product", product.get());

		return "product/view";
	}
}
