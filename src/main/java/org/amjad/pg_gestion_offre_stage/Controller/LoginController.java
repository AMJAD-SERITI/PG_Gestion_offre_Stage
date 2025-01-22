package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.DTO.LoginRequest;
import org.amjad.pg_gestion_offre_stage.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping
    public String login() {
        return "Login page";
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDetails.getUsername(), password, userDetails.getAuthorities()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .orElse("");

        switch (role) {
            case "ADMIN":
                return ResponseEntity.ok("/AdminPage");
            case "CONDIDAT":
                return ResponseEntity.ok("/Candidatures");
            case "ENCADRANT":
                return ResponseEntity.ok("/SupervisorPage");
            case "RH":
                return ResponseEntity.ok("/DemandsPage");
            case"STAGIAIRE":
                return ResponseEntity.ok("/Encadrant");
            default:
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
        }
    }
}