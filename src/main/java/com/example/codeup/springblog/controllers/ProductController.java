package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Product;
import com.example.codeup.springblog.reposotories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    //dependency injection

    ProductRepository productDao;

    public ProductController(ProductRepository productDao) {
        this.productDao = productDao;
    }
    //get all methods with jpa
    @GetMapping("/products")
    public String showAllProducts(Model vModel) {

        List<Product> productList = productDao.findAll();

        // pass products to view

        vModel.addAttribute("products", productList);
        return "products/index";
    }

    //create methods with jpa
    @GetMapping("/products/create/test")
    public String createProducts() {
    Product product = new Product("Pug", 2929);
    productDao.save(product);


        return "redirect:/products";
    }

    //delete methods with jpa
    @GetMapping("/products/delete/test")
    public String deleteProducts() {

//        productDao.deleteById(NUMBER_HERE);
//        productDao.findOne()

        return "redirect:/products";
    }

    //find by id methods with jpa
    @GetMapping("/products/test/{id}")
    public String findOne(@PathVariable long id) {
//        System.out.println(productDao.findOne(id).get());
        return "redirect:/products";
    }




}
