package com.esprit.project.service;



import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.project.entity.Comment;
import com.esprit.project.repository.CommentRepositroy;


@Service
public class CommentServiceImpl implements ICommentService {
     
	
	@Autowired
	 CommentRepositroy commentrepository;
	
	private static final Logger L = LogManager.getLogger(CommentServiceImpl.class);
	
	@Override
	public List<Comment> retrieveAllComments() {
		
		List<Comment> Comments = (List<Comment>) commentrepository.findAll();
		for (Comment  comment :   Comments){
			L.info("comment +++ : " + comment);
		}
		return   Comments ;
	}

	@Override
	public Comment saveComment(Comment c) {
		
		return commentrepository.save(c);
		
	}

	@Override
	public void deleteById(String id) {
		
		commentrepository.deleteById(Long.parseLong(id));
		
	}
/*	@Override
	public List<Comment> searchComments(String pattern) {
        return commentrepository.findCommentsByTextContaining(pattern);
	}*/


	
}
