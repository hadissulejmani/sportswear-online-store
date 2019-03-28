package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.models.Product;

@Controller
public class ProductController {

	private Long counter;
    private List<Product> productList = null;

    private List<Manufacturer> manufacturers = null;
    private List<Category> categories = null;
    
    @PostConstruct
    public void init() {
        counter = 1l;
        manufacturers = new ArrayList<>();
        Manufacturer m = new Manufacturer(Long.parseLong("11111"), "NIKE");
        Manufacturer n = new Manufacturer(Long.parseLong("22222"), "Adidas");
        Manufacturer k = new Manufacturer(Long.parseLong("33333"), "Puma");
        manufacturers.add(m);
        manufacturers.add(m);
        manufacturers.add(m);
        
        categories = new ArrayList<>();
        Category c1 = new Category(Long.parseLong("9999"), "MAICA");
        Category c2 = new Category(Long.parseLong("7777"), "PANTOLLA");
        Category c3 = new Category(Long.parseLong("8888"), "KMISHA");
        
        productList = new ArrayList<>();
        productList.add(new Product(Long.parseLong("1"), "Bruno", "Kurxho hic", "", c1, m));
        productList.add(new Product(Long.parseLong("1"), "Mars", "Kurxho hic", "", c1, m));
        productList.add(new Product(Long.parseLong("1"), "Zambac", "Kurxho hic", "", c2, n));
        productList.add(new Product(Long.parseLong("1"), "Sephora", "Kurxho hic", "", c2, k));
        productList.add(new Product(Long.parseLong("1"), "Selenica", "Kurxho hic", "", c3, k));
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("productList", productList);
        return "products";
    }
    
    
    @GetMapping("/products/{id}")
    public String singleProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", productList.stream().filter(p -> p.getId() == id).findFirst().get());
        return "single-product";
    }
    
    
    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("new-product", new Product());
        return "product-add";
    }
    
    @PostMapping("/products/add")
    public String addSubmit(@ModelAttribute Product p, Model model) {
    	return "product-add";
    }

}
