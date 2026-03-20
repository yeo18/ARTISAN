package com.artisan.artisan.Security;

import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Entity.Client;
import com.artisan.artisan.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return utilisateurRepository.findByEmail(email)
                .map(user -> {
                    List<SimpleGrantedAuthority> authorities;
                    if (user instanceof Artisan) {
                        authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_ARTISAN"));
                    } else if (user instanceof Client) {
                        authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_CLIENT"));
                    } else {
                        authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
                    }
                    return new User(user.getEmail(), user.getMotpasse(), authorities);
                })
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email: " + email));
    }
}
