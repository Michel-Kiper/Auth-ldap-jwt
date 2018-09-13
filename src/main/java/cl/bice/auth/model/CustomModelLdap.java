package cl.bice.auth.model;

import java.util.Collection;

import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomModelLdap implements UserDetailsContextMapper{

	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
			Collection<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mapUserToContext(UserDetails user, DirContextAdapter ctx) {
		// TODO Auto-generated method stub
	}

}
