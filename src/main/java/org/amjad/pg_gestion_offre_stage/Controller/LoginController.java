package org.amjad.pg_gestion_offre_stage.Controller;

import java.util.HashMap;
import java.util.Map;

import org.amjad.pg_gestion_offre_stage.Config.JwtTokenUtil;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping
    public String login() {
        return "Login page";
    }

@PostMapping
public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
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

    String redirectUrl;
    switch (role) {
        case "ADMIN":
            redirectUrl = "/AdminPage";
            break;
        case "CONDIDAT":
            redirectUrl = "/Candidatures";
            break;
        case "ENCADRANT":
            redirectUrl = "/SupervisorPage";
            break;
        case "RH":
            redirectUrl = "/DemandsPage";
            break;
        case "STAGIAIRE":
            redirectUrl = "/Encadrant";
            break;
        default:
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("error", "Access Denied"));
    }

    // Generate the token (assuming you have a method to do this)
    String token = jwtTokenUtil.generateToken(userDetails);

    // Return both the token and the redirect URL
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    response.put("redirectUrl", redirectUrl);

    return ResponseEntity.ok(response);
}
}