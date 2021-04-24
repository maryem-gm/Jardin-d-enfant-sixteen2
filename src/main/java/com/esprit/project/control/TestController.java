package com.esprit.project.control;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/parent")
	@PreAuthorize("hasRole('PARENT')")
	public String parentAccess() {
		return "Parent Content.";
	}

	@GetMapping("/kidenrgarden")
	@PreAuthorize("hasRole('KINDERGARDEN')")
	public String kindergardenAccess() {
		return "kindergarden Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
