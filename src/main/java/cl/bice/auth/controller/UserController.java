package cl.bice.auth.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	

	@GetMapping("/saludos")
	@Secured("ROLE_MANAGERS")
	public String saludo() {
		return "Saludos";
	}
}
