package com.esprit.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Parent;*/
import com.esprit.project.entity.Post;
import com.esprit.project.entity.Reaction;
import com.esprit.project.entity.Type;
import com.esprit.project.entity.User;
import com.esprit.project.repository.KinderGardenRepository;
import com.esprit.project.repository.ParentRepository;
import com.esprit.project.repository.PostRepository;
import com.esprit.project.repository.UserRepository;


@Service
public class PostServiceImpl implements IPostService{
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
	public Post addPost(Post post, int userId) {
		User user= userRepository.findById((long)userId).get();
		post.setUser(user);
		return postRepository.save(post);
	}

	@Override
	public void deletePostById(String idPost) {
		postRepository.deleteById(Long.parseLong(idPost));
		
	}

	@Override
	public Post updatePost(Post p) {
		
		return postRepository.save(p);
	}

	@Override
	public List<Post> retrieveAllPosts() {
		List<Post> posts = (List<Post>) postRepository.findAll();
		for (Post post :  posts){
			L.info("post +++ : " + post);
		}
		return   posts ;
	}

	@Override
	public Optional<Post> retrievePost(String idPost) {
		Optional<Post> p = postRepository.findById(Long.parseLong(idPost));
		return  p ;
		
	}
	
	
	@Override
	public List<Post> getAllPostByUser(User user){
		return postRepository.getAllPostByUser(user);
		
	}
	
	@Override
	public int getNombrePostByUser(User user){
		return postRepository.getNombrePostByUser(user);
	}
	@Override
	public List<Post> getPostsPrefereParUser(int userId){
		User user= userRepository.findById((long)userId).get();
		List<Post> postsuser= new ArrayList<Post>();
		List<Post> posts= (List<Post>)postRepository.findAll();
		List<Type> types= new ArrayList<Type>();
		List<Post> postsPrefere= new ArrayList<Post>();
		for(Post post: user.getPosts()){
			postsuser.add(post);
		}
		for(Post post: postsuser){
			types.add(post.getType());
		}
		for(Post post: posts){
			if(types.contains(post.getType())){
				postsPrefere.add(post);
			}
			
		}
		return postsPrefere;
		
		
	}
	
	@Override
	public List<Post> getPostParHashtagAimeParUser(int userId){
		User user= userRepository.findById((long)userId).get();
		List<Reaction> userReactions= new ArrayList<Reaction>();
		List<Post> postLiked= new ArrayList<Post>();
		List<String> hashtagLiked= new ArrayList<String>();
		List<Post> posts= (List<Post>)postRepository.findAll();
		List<Post> postPrefere= new ArrayList<Post>();
		for(Reaction reaction: user.getReactions1()){
			userReactions.add(reaction);		
		}
		for(Reaction reaction: userReactions){
			if(reaction.isStatusLike()==true){
				postLiked.add(reaction.getPost1());
			}	
		}
		for(Post post: postLiked){
			hashtagLiked.add(post.getDescriptionPost());		
		}
		for(Post post: posts){
			if(hashtagLiked.contains(post.getDescriptionPost())){
				postPrefere.add(post);
			}
		}
		return postPrefere;
		
		
		
	}

	
	

}
