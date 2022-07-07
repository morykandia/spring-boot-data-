package com.entreprise.assurance.controller;


import com.entreprise.assurance.model.Category;
import com.entreprise.assurance.model.Product;
import com.entreprise.assurance.service.CategoryService;
import com.entreprise.assurance.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService  categoryService;

    @RequestMapping(value = "api/products", method = RequestMethod.GET)
    public Iterable<Product> getProduct(){
        return productService.getProducts();
    }

    @RequestMapping(value = "api/products/{id}", method = RequestMethod.GET)
    public String getProductId(@PathVariable Integer id ){
        Optional<Product> optProduct = productService.getProductById(id);
        Product productId1 = optProduct.get();
        return  productId1.getName();
    }


    @RequestMapping(value = "api/products/add", method = RequestMethod.GET)
    @Transactional
    public Product addProduct( ){

        Category newCategory = new Category();
        newCategory.setName("Promotion");
        newCategory = categoryService.addCategory(newCategory);

        Product newproduct = new Product();
        newproduct.setName("AssuranceAuTiersFidelite");
        newproduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
        newproduct.setCost(1100);

        newCategory.addProduct(newproduct);
        newproduct = productService.addProduct(newproduct);

        return newproduct;

    }
    @RequestMapping(value = "api/products/update/{id}", method = RequestMethod.GET)
    public Product UpdateProduct(@PathVariable Integer id ){
        Product existingProduct = productService.getProductById(id).get();
        existingProduct.setCost(3000);
        productService.addProduct(existingProduct);
        existingProduct = productService.getProductById(1).get();

        return existingProduct;
    }

    @RequestMapping(value = "api/products/delete", method = RequestMethod.DELETE)
    public  void deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
    }

}
