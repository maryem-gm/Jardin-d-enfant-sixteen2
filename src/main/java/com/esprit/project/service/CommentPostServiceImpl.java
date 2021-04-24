package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.CommentPost;
import com.esprit.project.entity.Post;
import com.esprit.project.entity.User;
import com.esprit.project.repository.CommentPostRepository;
import com.esprit.project.repository.KinderGardenRepository;
import com.esprit.project.repository.ParentRepository;
import com.esprit.project.repository.PostRepository;
import com.esprit.project.repository.UserRepository;
@Service
public class CommentPostServiceImpl implements ICommentPostService {
	@Autowired
	CommentPostRepository commentPostRepository;
	@Autowired
	PostRepository postRepository;
	@Autowired
	ParentRepository parentRepository;
	@Autowired
	KinderGardenRepository kinderGardenRepository;
	@Autowired
	UserRepository userRepository;
private static final Logger L = LogManager.getLogger(PostServiceImpl.class);


	@Override
	public CommentPost addCommentPost(CommentPost cp, int idPost, int idUser) {
		Post post= postRepository.findById((long)idPost).get();
		User user= userRepository.findById((long)idUser).get();
		cp.setPost(post);
		cp.setUser2(user);
		post.setNumbCommentPost(post.getNumbCommentPost()+1);
		postRepository.save(post);
		return commentPostRepository.save(cp);
	}

	@Override
	public void deleteCommentPostById(String idCommentPost) {
		commentPostRepository.deleteById(Long.parseLong(idCommentPost));
		
	}

	@Override
	public CommentPost updateCommentPost(CommentPost cp) {
		
		return commentPostRepository.save(cp);
	}

	@Override
	public List<CommentPost> retrieveAllCommentsPost() {
		List<CommentPost> commentsPost = (List<CommentPost>) commentPostRepository.findAll();
		for (CommentPost commentPost :  commentsPost){
			L.info("commentPost +++ : " + commentPost);
		}
		return   commentsPost ;
	}

	@Override
	public Optional<CommentPost> retrieveCommentPost(String idCommentPost) {
		Optional<CommentPost> cp = commentPostRepository.findById(Long.parseLong(idCommentPost));
		return  cp ;
		
	}
	
	
	
	@Override
	public List<CommentPost> getAllCommentByUser(User user){
		return commentPostRepository.getAllCommentByUser(user);
	}
	
	@Override
	public int getNombreCommentByUser(User user){
		return commentPostRepository.getNombreCommentByUser(user);
	}
	
	@Override
	public List<CommentPost> getAllCommentByPost(Post post){
		return commentPostRepository.getAllCommentByPost(post);
	}
	
	@Override
	public int getNombreCommentByPost(Post post){
		return commentPostRepository.getNombreCommentByPost(post);
	}
	
	
	

}
