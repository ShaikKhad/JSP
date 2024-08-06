package org.jsp;

import java.util.List;

import javax.persistence.criteria.Fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    
public String listProducts(@RequestParam(value="page",defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "5")int size, Model model) {
	Pageable pageable=PageRequest.of(page, size);
	Page<Product> pP= ProductService.findAll(pageable);
	model.addAttribute("prodcuts",pP.getContent());
	model.addAttribute("currnetPage", page);
	model.addAttribute("totalPages",pP.getTotalPages());
	return "products/list";
	
}
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Test endpoint working!";
    }
    @GetMapping("/welcome")
    public String viewHomePage(Model model) {
        model.addAttribute("listProducts", productRepository.findAll());
        return "Index";
    }

    @GetMapping("/insertProduct")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/updateProduct/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> 
            new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> 
            new IllegalArgumentException("Invalid product Id:" + id));
        productRepository.delete(product);
        return "redirect:/";
    }
   
}
