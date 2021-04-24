package com.esprit.project.service;



import java.util.List;

import com.esprit.project.entity.Comment;

public interface ICommentService {
          
	Comment saveComment(Comment c);
	public void  deleteById(String id);
	List<Comment>  retrieveAllComments();
	//List<Comment> searchComments(String test);
	
}
