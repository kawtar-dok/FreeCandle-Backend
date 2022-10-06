package com.kali.library.FreeCandleBackend.controller.auth;


import com.kali.library.FreeCandleBackend.dao.*;
import com.kali.library.FreeCandleBackend.model.ERole;
import com.kali.library.FreeCandleBackend.model.Role;
import com.kali.library.FreeCandleBackend.model.User;
import com.kali.library.FreeCandleBackend.payload.request.LoginRequest;
import com.kali.library.FreeCandleBackend.payload.request.SignupRequest;
import com.kali.library.FreeCandleBackend.payload.response.JwtResponse;
import com.kali.library.FreeCandleBackend.payload.response.MessageResponse;
import com.kali.library.FreeCandleBackend.security.jwt.JwtUtils;
import com.kali.library.FreeCandleBackend.security.jwt.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/auth")
public class AuthRest {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SectionRepository sectionsRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    AdminRepository adminRepo;
    @Autowired
    AdherentRepository adherentRepo;
    @Autowired
    BibliothecaireRepository  bibliothecaireRepo;

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/admin/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        ResponseCookie cookie = jwtUtils.generateJwtCookie(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getFirstName(),
                        userDetails.getLastName(),
                        userDetails.getEmail(),
                        roles));
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }


        // Create new user's account
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = RoleRepository.findByName(ERole.ROLE_ADHERENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = RoleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "bibliothecairer":
                        Role modRole = RoleRepository.findByName(ERole.ROLE_BIBLIOTHECAIRE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;

                    default:
                        Role userRole = RoleRepository.findByName(ERole.ROLE_ADHERENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
       //user.setRoles(roles);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/admin/signout")
    public ResponseEntity<?> logoutUser() {
        // Clear JWT Token
        SecurityContextHolder.getContext().setAuthentication(null);

        // Clear JWT Cookie
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("User logged out successfully!"));
    }












}
