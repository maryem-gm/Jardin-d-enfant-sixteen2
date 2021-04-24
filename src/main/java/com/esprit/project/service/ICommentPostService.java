package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.CommentPost;
import com.esprit.project.entity.Post;
import com.esprit.project.entity.User;

public interface ICommentPostService {
	  CommentPost addCommentPost(CommentPost cp, int idPost, int idUser);
	  void deleteCommentPostById(String idCommentPost);
	  CommentPost updateCommentPost(CommentPost cp);
	  List<CommentPost> retrieveAllCommentsPost();
	  Optional<CommentPost> retrieveCommentPost(String idCommentPost);
	  List<CommentPost> getAllCommentByUser(User user);
	  int getNombreCommentByUser(User user);
	  List<CommentPost> getAllCommentByPost(Post post);
	  int getNombreCommentByPost(Post post);
	  

}
