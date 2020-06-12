package pe.edu.upc.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Rol;
import pe.edu.upc.repository.IUserRepository;



@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository uR;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		pe.edu.upc.entity.User user = uR.findByUsername(username);

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Rol role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRol()));
		}

		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

}
