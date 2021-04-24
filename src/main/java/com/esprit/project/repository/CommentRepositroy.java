package com.esprit.project.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Comment;

@Repository
public interface CommentRepositroy  extends CrudRepository<Comment , Long> {
	
	/*@Query("SELECT c FROM Comment c WHERE c.commentContent LIKE %?1%") 
	public List<Comment> findCommentsByTextContaining(String pattern);
	*/
	


	
	
}
