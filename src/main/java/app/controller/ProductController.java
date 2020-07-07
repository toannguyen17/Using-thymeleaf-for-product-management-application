package app.controller;

import app.model.Product;
import app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping
	public String index(Model model){
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "products/index";
	}

	@GetMapping("/add")
	public String addGet(){
		return "products/add";
	}

	@PostMapping("/add")
	public String addPost(@ModelAttribute Product product, Model model){
		productService.save(product);
		model.addAttribute("mess", "add success.");
		return "products/add";
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model){
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "products/detail";
	}

	@GetMapping("/edit/{id}")
	public String editGet(@PathVariable Long id, Model model){
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "products/edit";
	}

	@PostMapping("/edit/{id}")
	public String editPost(@ModelAttribute Product product, Model model){
		productService.save(product);
		model.addAttribute("mess", "edit success.");
		model.addAttribute("product", product);
		return "products/edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		productService.delete(id);
		return "redirect:/products";
	}
}
