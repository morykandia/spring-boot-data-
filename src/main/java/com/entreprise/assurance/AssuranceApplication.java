package com.entreprise.assurance;

import com.entreprise.assurance.model.Category;
import com.entreprise.assurance.model.Comment;
import com.entreprise.assurance.model.Product;
import com.entreprise.assurance.service.CategoryService;
import com.entreprise.assurance.service.CommentService;
import com.entreprise.assurance.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootApplication
public class AssuranceApplication implements CommandLineRunner {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(AssuranceApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/**
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));
		System.out.println("\n");
		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));
		System.out.println("\n");


		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getContent()));
		System.out.println("\n");

		System.out.println("\n");
		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();
		System.out.println(productId1.getName());
		productId1.getComments().forEach(
				comment -> System.out.println(comment.getContent()));

		productId1.getCategories().forEach(
				category -> System.out.println(category.getName()));

		System.out.println("\n");
		Optional<Category> optCategory = categoryService.getCategoryById(1);
		Category categoryId1 = optCategory.get();
		System.out.println(categoryId1.getName());

		System.out.println("\n");
		Optional<Comment> optComment = commentService.getCommentById(1);
		Comment commentId1 = optComment.get();
		System.out.println(commentId1.getContent());

		System.out.println("\n");
		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));

		Category newCategory = new Category();
		newCategory.setName("Promotion");

		newCategory = categoryService.addCategory(newCategory);

		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));

		Product newProduct = new Product();
		newProduct.setName("AssuranceAuTiersFidelite");
		newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
		newProduct.setCost(1100);

		//newCategory.addProduct(newProduct);
		newProduct = productService.addProduct(newProduct);

		productService.getProducts().forEach(
				product -> System.out.println(product.getName()));

		newProduct.getCategories().forEach(
				category -> System.out.println(category.getName()));

		Comment newComment = new Comment();
		newComment.setContent("Assurance extraordinaire!");


		commentService.addComment(newComment);



**/

	}

}
