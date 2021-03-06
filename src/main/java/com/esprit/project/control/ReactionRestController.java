package com.esprit.project.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Reaction;
import com.esprit.project.repository.ReactionRepository;
import com.esprit.project.service.IReactionService;

@RestController
public class ReactionRestController {
	@Autowired
	IReactionService iReactionService;
	@Autowired
	ReactionRepository reactionRepository;
	@PutMapping("/addLike/{idPost}/{idUser}")
	public void addLike(@RequestBody Reaction reaction, @PathVariable("idPost") int idPost, @PathVariable("idUser") int idUser){
		iReactionService.addLike(reaction,idPost, idUser);
		
	}
	@PutMapping("/addDislike/{idPost}/{idUser}")
	public void addDislike(@RequestBody Reaction reaction, @PathVariable("idPost") int idPost, @PathVariable("idUser") int idUser){
		iReactionService.addDislike(reaction, idPost, idUser);
		
	}
	@PutMapping("/addSignal/{idPost}/{idUser}")
	public void addSignal(@RequestBody Reaction reaction, @PathVariable("idPost") int idPost, @PathVariable("idUser") int idUser){
		iReactionService.addSignal(reaction, idPost, idUser);
	}
	@PutMapping("/addLikeAcomment/{idComment}/{idUser}")
	public void addLikeAcomment(@RequestBody Reaction reaction, @PathVariable("idComment") int idComment, @PathVariable("idUser") int idUser){
		iReactionService.addLikeAcomment(reaction, idComment, idUser);
	}
	@PutMapping("/addSignalAcomment/{idComment}/{idUser}")
	public void addSignalAcomment(@RequestBody Reaction reaction, @PathVariable("idComment") int idComment, @PathVariable("idUser") int idUser){
		iReactionService.addSignalAcomment(reaction, idComment, idUser);
	}

}
