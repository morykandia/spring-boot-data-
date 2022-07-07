package com.entreprise.assurance.service;

import com.entreprise.assurance.model.Category;

import com.entreprise.assurance.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories() {

        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {

        return categoryRepository.findById(id);
    }

    public Category addCategory(Category category) {

        return categoryRepository.save(category);
    }


    public void deleteCategoryById(Integer id) {

        categoryRepository.deleteById(id);
    }

    public Iterable<Category> getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }


    public Iterable<Category> getCategoriesByProductName(String name) {
        return categoryRepository.findByProductsName(name);
    }




}
