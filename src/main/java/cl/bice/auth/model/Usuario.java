package cl.bice.auth.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Usuario {
	
	private String username;
	private String password;
	private String group;
}
