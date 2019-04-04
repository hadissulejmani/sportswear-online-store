package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.ManufacturerNotFoundException;
import com.example.demo.CategoryNotFoundException;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

	private Long counter;
    private List<Product> productList = null;

    private List<Manufacturer>  manufacturers = new ArrayList<>();
    private List<Category> categories = null;


    public ProductController() {
        counter = 1l;
        manufacturers = new ArrayList<>();
        Manufacturer m = new Manufacturer(Long.parseLong("11111"), "NIKE");
        Manufacturer n = new Manufacturer(Long.parseLong("22222"), "Adidas");
        Manufacturer k = new Manufacturer(Long.parseLong("33333"), "Puma");
        manufacturers.add(m);
        manufacturers.add(n);
        manufacturers.add(k);

        categories = new ArrayList<>();
        Category c1 = new Category(Long.parseLong("9999"), "MAICA");
        Category c2 = new Category(Long.parseLong("7777"), "PANTOLLA");
        Category c3 = new Category(Long.parseLong("8888"), "KMISHA");
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);

        String u = "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";

        productList = new ArrayList<>();
        productList.add(new Product(Long.parseLong("1"), "Bruno", "Kurxho hic", u, c1, m));
        productList.add(new Product(Long.parseLong("1"), "Mars", "Kurxho hic", u, c1, m));
        productList.add(new Product(Long.parseLong("1"), "Zambac", "Kurxho hic", u, c2, n));
        productList.add(new Product(Long.parseLong("1"), "Sephora", "Kurxho hic", u, c2, k));
        productList.add(new Product(Long.parseLong("1"), "Selenica", "Kurxho hic", u, c3, k));
    }

    @GetMapping("")
    public String products(Model model) {
        model.addAttribute("productList", productList);
        return "products";
    }
    
    
    @GetMapping("/{id}")
    public String singleProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", productList.stream().filter(p -> p.getId() == id).findFirst().get());
        return "single-product";
    }


    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("manufacturerList", manufacturers);
        model.addAttribute("categoryList", categories);
        model.addAttribute("newProduct", new Product());
        return "product-add";
    }

    @ExceptionHandler({ManufacturerNotFoundException.class})
    @PostMapping("")
    public String addDeviceWithModelAttribute(@ModelAttribute Product p,
                                              @RequestParam("category.id") Long categoryId,
                                              @RequestParam("manufacturer.id") Long manufacturerId) throws IOException {

        Manufacturer m;
        m = manufacturers.stream().filter((k) -> k.getId().equals(manufacturerId)).findFirst().get();
        Category c = categories.stream().filter(t->t.getId().equals(categoryId)).findFirst().get();

        p.setManufacturer(m);
        p.setCategory(c);

        productList.add(p);
        return "redirect:/products";
    }

    private Long getNextId() {
        return counter++;
    }

}
