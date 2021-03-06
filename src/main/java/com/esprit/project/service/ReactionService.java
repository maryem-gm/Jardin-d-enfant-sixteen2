package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.CommentPost;
import com.esprit.project.entity.Post;
import com.esprit.project.entity.Reaction;
import com.esprit.project.entity.User;
import com.esprit.project.repository.CommentPostRepository;
import com.esprit.project.repository.PostRepository;
import com.esprit.project.repository.ReactionRepository;
import com.esprit.project.repository.UserRepository;

@Service
public class ReactionService implements IReactionService{
	
	private static final Logger L = LogManager.getLogger(PostServiceImpl.class);
	
	
	@Autowired
	ReactionRepository reactionRepository;
	@Autowired
	PostRepository postRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CommentPostRepository commentPostRepository;
	@Override
	public void addLike(Reaction r, int idPost, int idUser) {
		
		Post post= postRepository.findById((long) idPost).get();
		User user=userRepository.findById((long)idUser).get();
		int i=0;
		boolean test=false;
		while((test==false) && (i==post.getReactions().size()-1)){
			if (post.getReactions().get(i).isStatusLike()==true && (post.getReactions().get(i).getPost1().getIdPost()==((long)idPost)) && post.getReactions().get(i).getUser1().getId()==((long)idUser)){
				post.getReactions().get(i).setStatusLike(false);
				post.setNumbLikePost(post.getNumbLikePost()-1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
			}
			if (post.getReactions().get(i).isStatusLike()==false && (post.getReactions().get(i).getPost1().getIdPost()==((long)idPost)) && post.getReactions().get(i).getUser1().getId()==((long)idUser)){
				post.getReactions().get(i).setStatusLike(true);
				post.setNumbLikePost(post.getNumbLikePost()+1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
			}
			i=i+1;
		}
			
			if(test==false){
				r.setPost1(post);
				r.setUser1(user);
				r.setStatusLike(true);
				post.setNumbLikePost(post.getNumbLikePost()+1);
				postRepository.save(post);
				reactionRepository.save(r);
			}
			
		
		
		
		
	}
	
	
	@Override
	public void addDislike(Reaction r, int idPost, int idUser) {
		
		Post post= postRepository.findById((long) idPost).get();
		User user=userRepository.findById((long)idUser).get();
		int i=0;
		boolean test=false;
		while((test==false) && (i==post.getReactions().size()-1)){
			if (post.getReactions().get(i).isStatusDislike()==true && (post.getReactions().get(i).getPost1().getIdPost()==((long)idPost)) && post.getReactions().get(i).getUser1().getId()==((long)idUser)){
				post.getReactions().get(i).setStatusDislike(false);
				post.setNumbDislikePost(post.getNumbDislikePost()-1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
			}
			if (post.getReactions().get(i).isStatusDislike()==false && (post.getReactions().get(i).getPost1().getIdPost()==((long)idPost)) && post.getReactions().get(i).getUser1().getId()==((long)idUser)){
				post.getReactions().get(i).setStatusDislike(true);
				post.setNumbDislikePost(post.getNumbDislikePost()+1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
			}
			i=i+1;
		}
			
			if(test==false){
				r.setPost1(post);
				r.setUser1(user);
				r.setStatusDislike(true);
				post.setNumbDislikePost(post.getNumbDislikePost()+1);
				postRepository.save(post);
				reactionRepository.save(r);
			}
			
		
		
		
		
	}
	
	@Override
	public void addSignal(Reaction r, int idPost, int idUser) {
		Post post= postRepository.findById((long) idPost).get();
		User user=userRepository.findById((long)idUser).get();
		int i=0;
		boolean test=false;
		while((test==false) && (i==post.getReactions().size()-1)){
			if (post.getReactions().get(i).isStatusSignal()==true && (post.getReactions().get(i).getPost1().getIdPost()==((long)idPost)) && post.getReactions().get(i).getUser1().getId()==((long)idUser)){
				post.getReactions().get(i).setStatusSignal(false);
				post.setNumbSignalPost(post.getNumbSignalPost()-1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
			}
			if (post.getReactions().get(i).isStatusSignal()==false && (post.getReactions().get(i).getPost1().getIdPost()==((long)idPost)) && post.getReactions().get(i).getUser1().getId()==((long)idUser)){
				post.getReactions().get(i).setStatusSignal(true);
				post.setNumbSignalPost(post.getNumbSignalPost()+1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
			}
			i=i+1;
		}
			
			if(test==false){
				r.setPost1(post);
				r.setUser1(user);
				r.setStatusSignal(true);
				post.setNumbSignalPost(post.getNumbSignalPost()+1);
				postRepository.save(post);
				reactionRepository.save(r);
			}
			if(post.getNumbSignalPost()>3){
				postRepository.delete(post);
			}
		
		
		
		
		
	}
	@Override
	public void addLikeAcomment(Reaction r, int idComment, int idUser) {
		
		CommentPost commentPost= commentPostRepository.findById((long)idComment).get();
		User user=userRepository.findById((long)idUser).get();
		int i=0;
		boolean test=false;
		while((test==false) && (i==commentPost.getReactions1().size()-1)){
			if (commentPost.getReactions1().get(i).isStatusLike()==true && (commentPost.getReactions1().get(i).getCommentPost().getId()==((long)idComment)) && commentPost.getReactions1().get(i).getCommentPost().getId()==((long)idUser)){
				commentPost.getReactions1().get(i).setStatusLike(false);
				commentPost.setNumbLikeComment(commentPost.getNumbLikeComment()-1);
				commentPostRepository.save(commentPost);
				reactionRepository.save(commentPost.getReactions1().get(i));
				test=true;
			}
			if (commentPost.getReactions1().get(i).isStatusLike()==false && (commentPost.getReactions1().get(i).getCommentPost().getId()==((long)idComment)) && commentPost.getReactions1().get(i).getCommentPost().getId()==((long)idUser)){
				commentPost.getReactions1().get(i).setStatusLike(true);
				commentPost.setNumbLikeComment(commentPost.getNumbLikeComment()+1);
				commentPostRepository.save(commentPost);
				reactionRepository.save(commentPost.getReactions1().get(i));
				test=true;
			}
			i=i+1;
		}
			
			if(test==false){
				r.setCommentPost(commentPost);
				r.setUser1(user);
				r.setStatusLike(true);
				commentPost.setNumbLikeComment(commentPost.getNumbLikeComment()+1);
				commentPostRepository.save(commentPost);
				reactionRepository.save(r);
			}	
		
		
	}
	
	@Override
	public void addSignalAcomment(Reaction r, int idComment, int idUser) {
		
		CommentPost commentPost= commentPostRepository.findById((long)idComment).get();
		User user=userRepository.findById((long)idUser).get();
		int i=0;
		boolean test=false;
		while((test==false) && (i==commentPost.getReactions1().size()-1)){
			if (commentPost.getReactions1().get(i).isStatusSignal()==true && (commentPost.getReactions1().get(i).getCommentPost().getId()==((long)idComment)) && commentPost.getReactions1().get(i).getCommentPost().getId()==((long)idUser)){
				commentPost.getReactions1().get(i).setStatusSignal(false);
				commentPost.setNumbSignalComment(commentPost.getNumbSignalComment()-1);
				commentPostRepository.save(commentPost);
				reactionRepository.save(commentPost.getReactions1().get(i));
				test=true;
			}
			if (commentPost.getReactions1().get(i).isStatusSignal()==false && (commentPost.getReactions1().get(i).getCommentPost().getId()==((long)idComment)) && commentPost.getReactions1().get(i).getCommentPost().getId()==((long)idUser)){
				commentPost.getReactions1().get(i).setStatusSignal(true);
				commentPost.setNumbSignalComment(commentPost.getNumbSignalComment()+1);
				commentPostRepository.save(commentPost);
				reactionRepository.save(commentPost.getReactions1().get(i));
				test=true;
			}
			i=i+1;
		}
			
			if(test==false){
				r.setCommentPost(commentPost);
				r.setUser1(user);
				r.setStatusSignal(true);
				commentPost.setNumbSignalComment(commentPost.getNumbSignalComment()+1);
				commentPostRepository.save(commentPost);
				reactionRepository.save(r);
			}
			if(commentPost.getNumbSignalComment()>3){
				commentPostRepository.delete(commentPost);
			}
		
		
	}
	

	@Override
	public void deleteReactionById(String idPost) {
		reactionRepository.deleteById(Long.parseLong(idPost));
		
	}

	@Override
	public Reaction updateReaction(Reaction r) {
		
		return reactionRepository.save(r);
	}

	@Override
	public List<Reaction> retrieveAllReactions() {
		List<Reaction> reactions = (List<Reaction>) reactionRepository.findAll();
		for (Reaction reaction :  reactions){
			L.info("reaction +++ : " + reactions);
		}
		return   reactions ;
	}

	@Override
	public Optional<Reaction> retrieveReaction(String idReaction) {
		Optional<Reaction> r = reactionRepository.findById(Long.parseLong(idReaction));
		return  r ;
		
	}
	
	
	

}
