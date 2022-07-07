package com.entreprise.assurance.controller;


import com.entreprise.assurance.model.Comment;

import com.entreprise.assurance.model.Product;
import com.entreprise.assurance.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "api/comments", method = RequestMethod.GET)
    public Iterable<Comment> getProduct(){
        return commentService.getComments();
    }


    @RequestMapping(value = "api/comments/{id}", method = RequestMethod.GET)
    public String getCommentId(@PathVariable Integer id ){
        Optional<Comment> optComment = commentService.getCommentById(id);
       Comment CommentId1 = optComment.get();
        return  CommentId1.getContent();
    }


    @RequestMapping(value = "api/comments/add", method = RequestMethod.GET)
    public Comment addComment( ){

        Comment newComment = new Comment();
        Product newProduct = new Product();
        newProduct.addComment(newComment);
        newComment.setContent("Assurance extraordinaire!");
        newComment = commentService.addComment(newComment);
        return newComment;
    }

    @RequestMapping(value = "api/comments/delete", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable Integer id){
        commentService.deleteCommentById(id);
    }










}
