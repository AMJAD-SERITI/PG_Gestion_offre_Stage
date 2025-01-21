package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Admin;
import org.amjad.pg_gestion_offre_stage.Entity.Rh;
import org.amjad.pg_gestion_offre_stage.Dao.CondidatRepo;
import org.amjad.pg_gestion_offre_stage.Dao.EncadrantRepo;
import org.amjad.pg_gestion_offre_stage.Dao.AdminRepo;
import org.amjad.pg_gestion_offre_stage.Dao.RhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CondidatRepo condidatRepository;

    @Autowired
    private EncadrantRepo encadrantRepository;

    @Autowired
    private AdminRepo adminRepository;

    @Autowired
    private RhRepo rhRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Check if the user is a Condidat
        Condidat condidat = condidatRepository.findByEmail(email).orElse(null);
        if (condidat != null) {
            authorities.add(new SimpleGrantedAuthority("CONDIDAT"));
            return new org.springframework.security.core.userdetails.User(condidat.getEmail(), condidat.getPassword(), authorities);
        }

        // Check if the user is an Encadrant
        Encadrant encadrant = encadrantRepository.findByEmail(email).orElse(null);
        if (encadrant != null) {
            authorities.add(new SimpleGrantedAuthority("ENCADRANT"));
            return new org.springframework.security.core.userdetails.User(encadrant.getEmail(), encadrant.getPassword(), authorities);
        }

        // Check if the user is an Admin
        Admin admin = adminRepository.findByEmail(email).orElse(null);
        if (admin != null) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(), authorities);
        }

        // Check if the user is an Rh
        Rh rh = rhRepository.findByEmail(email).orElse(null);
        if (rh != null) {
            authorities.add(new SimpleGrantedAuthority("RH"));
            return new org.springframework.security.core.userdetails.User(rh.getEmail(), rh.getPassword(), authorities);
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}