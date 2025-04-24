package ir.digixo.controller;


import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class C01ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public String ListOfProducts(Model model)
    {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list-products";
    }

    @GetMapping("/formForAddProduct")
    public String formForAddProduct(Model model)
    {
        Product product = new Product();
        model.addAttribute("product",product);
        return "add-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product)
    {
        productService.save(product);
        return "redirect:/allProducts";
    }


    //todo: update
    @GetMapping("/formForUpdate")
    public String formForUpdateProduct(@RequestParam("ProductId") Long productId, Model model)
    {
        Product productServiceById = productService.findById(productId);
        model.addAttribute("product", productServiceById);
        return "add-product";
    }


    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("ProductId") Long productId)
    {
       productService.delete(productId);
        return "redirect:/allProducts";
    }

}
