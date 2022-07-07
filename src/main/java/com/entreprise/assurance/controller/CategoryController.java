package com.entreprise.assurance.controller;

import com.entreprise.assurance.model.Category;
import com.entreprise.assurance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "api/categories", method = RequestMethod.GET)
    public Iterable<Category> getProduct(){

        return categoryService.getCategories();
    }

    @RequestMapping(value = "api/categories/{id}", method = RequestMethod.GET)
    public String getCategoryId(@PathVariable Integer id ){
        Optional<Category> optCategory = categoryService.getCategoryById(id);
      Category category = optCategory.get();
        return  category.getName();
    }

    @RequestMapping(value = "api/categories/add", method = RequestMethod.GET)
    public Category addCategory( ){
        Category newCategory = new Category();
        newCategory.setName("Promotion");
        newCategory = categoryService.addCategory(newCategory);
        return newCategory;
    }

    @RequestMapping(value = "api/categories/delete", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
    }

}
