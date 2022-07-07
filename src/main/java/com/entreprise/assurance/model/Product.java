package com.entreprise.assurance.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produit")
@DynamicUpdate
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    @Getter
    private int productId;

    @Column(name = "nom")
    @Getter @Setter
    private String name;

    @Column(name = "description")
    @Getter @Setter
    private String description;

    @Column(name = "cout")

    private int cost;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    List<Comment> comments = new ArrayList<>();

    @ManyToMany(
            mappedBy = "products",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )

    private List<Category> categories = new ArrayList<>();


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setProduct(this);
    }

    public void removeComment(Comment comment) {

        comments.remove(comment);
        comment.setProduct(null);
    }


}
