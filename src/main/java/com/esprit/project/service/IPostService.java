package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Post;
import com.esprit.project.entity.User;

public interface IPostService {
	  Post addPost(Post post, int userId);
	  void deletePostById(String idPost);
	  Post updatePost(Post p);
	  List<Post> retrieveAllPosts();
	  Optional<Post> retrievePost(String idPost);
	  List<Post> getAllPostByUser(User user);
	  int getNombrePostByUser(User user);
	  List<Post> getPostsPrefereParUser(int userId);
	  List<Post> getPostParHashtagAimeParUser(int userId);

	 
}
