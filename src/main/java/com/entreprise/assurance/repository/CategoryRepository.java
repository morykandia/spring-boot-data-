package com.entreprise.assurance.repository;

import com.entreprise.assurance.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    public Iterable<Category> findByName(String name);

    public Iterable<Category> findByProductsName(String name);

}
