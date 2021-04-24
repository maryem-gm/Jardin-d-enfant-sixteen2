package com.esprit.project.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.project.entity.Comment;
import com.esprit.project.service.ICommentService;

@RestController
public class CommentRestController {
	@Autowired
	ICommentService commentservice;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-comments
	@GetMapping("/retrieve-all-comments")
	@ResponseBody
	public List<Comment> getComments() {
	List<Comment> Comments = commentservice.retrieveAllComments();
	return Comments;
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/add-comment
	@PostMapping("/add-comment")
	@ResponseBody
	public Comment addComment(@RequestBody Comment c ) {
	Comment comment = commentservice.saveComment(c);
	return comment;
	}

	//http://localhost:8081/SpringMVC/servlet/delete-comment/{comment-id}
		@DeleteMapping("/delete-comment/{comment-id}")
		@ResponseBody
		public void removeEvent(@PathVariable("comment-id") String id) {
			commentservice.deleteById(id);
}
		
		//URL: http://localhost:9293/SpringMVC/servlet/Comment/search/?pattern=
				/*		@GetMapping("/Comment/search/")
						public List<Comment> commentSearch(@RequestParam("pattern")String pattern){
							//System.out.println(pattern);
							return commentservice.searchComments(pattern);
						
						}*/
}
