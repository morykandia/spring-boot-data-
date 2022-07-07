package com.entreprise.assurance.repository;

import com.entreprise.assurance.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CommentRepository extends CrudRepository<Comment, Integer> {

    public Iterable<Comment> findByContentContaining(String expression);

}
