package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.config.security.MyUserPrincipal;
import be.cyimena.airbnb.assetsservice.requests.AuthenticationRequestDto;
import be.cyimena.airbnb.assetsservice.responses.AuthenticationResponseDto;
import be.cyimena.airbnb.assetsservice.config.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/assets")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailService;
    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody @Valid AuthenticationRequestDto req) throws Exception {
        // on appelle deux fois le loadUserByUsername -> vérifier si possiblité de factoriser
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        final MyUserPrincipal userDetails = (MyUserPrincipal) userDetailService.loadUserByUsername(req.getEmail());

        return new ResponseEntity<>(
                new AuthenticationResponseDto(userDetails.getFirstName(), userDetails.getLastName(), jwtUtil.generateToken(userDetails)),
                HttpStatus.OK);
    }
}
