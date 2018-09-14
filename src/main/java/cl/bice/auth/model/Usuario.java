package cl.bice.auth.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Usuario {
	String username;
	String password;
}
