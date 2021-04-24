package com.esprit.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Post;
import com.esprit.project.entity.User;


@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
	@Query("Select "
			+ "DISTINCT post from Post post "
			+ "join post.user us "
			+ "where us=:user")
    public List<Post> getAllPostByUser(@Param("user") User user);
	
	@Query("Select count(*) from Post post JOIN post.user us WHERE us=:user")
	public int getNombrePostByUser(@Param("user") User user);
	

}
