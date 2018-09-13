package cl.bice.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/saludos")
	public String saludo() {
		return "Saludos";
	}
}
