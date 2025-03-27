package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@Controller
public class BuyProductController {

    @Autowired
    private final ProductRepository productRepository;

    BuyProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/buyProduct")
    public String getBuyProduct(@RequestParam("productID") long productid, Model theModel){ 
        try {
            Product product = productRepository.findById(productid).get();
            product.setInv(product.getInv()-1);
            productRepository.save(product);
            
            return "confirmationbuyproduct";
        } catch (Exception e) {
            return "genericerror";

        }
    }
}
