package com.esprit.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.CommentPost;
import com.esprit.project.entity.Post;
import com.esprit.project.entity.User;

@Repository
public interface CommentPostRepository extends JpaRepository<CommentPost,Long> {
	@Query("Select "
			+ "DISTINCT cp from CommentPost cp "
			+ "join cp.user2 us "
			+ "where us=:user")
    public List<CommentPost> getAllCommentByUser(@Param("user") User user);
	
	@Query("Select count(*) from CommentPost cp JOIN cp.user2 us WHERE us=:user")
	public int getNombreCommentByUser(@Param("user") User user);
	
	@Query("Select "
			+ "DISTINCT cp from CommentPost cp "
			+ "join cp.post ps "
			+ "where ps=:post")
    public List<CommentPost> getAllCommentByPost(@Param("post") Post post);
	
	@Query("Select count(*) from CommentPost cp JOIN cp.post ps WHERE ps=:post")
	public int getNombreCommentByPost(@Param("post") Post post);
	

}
