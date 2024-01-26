package com.ptd.apirestaurant.controller;

import com.ptd.apirestaurant.dto.AuthenticationDTO;
import com.ptd.apirestaurant.dto.AuthenticationResponse;
import com.ptd.apirestaurant.service.jwt.UserDetailsServiceImpl;
import com.ptd.apirestaurant.share.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import static com.ptd.apirestaurant.share.utils.JwtUtil.SECRET;


@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getName(), authenticationDTO.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password!");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
            return null;
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getName());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new AuthenticationResponse(jwt);

    }
    @GetMapping("/expirationOfToken/{token}")
    public ResponseEntity<String> getExpirationOfToken(@PathVariable("token") String token){
        Date date =jwtUtil.extractExpiration(token);
        DateFormat pstFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        pstFormat.setTimeZone(TimeZone.getTimeZone("VST"));
        return  new ResponseEntity<>(pstFormat.format(date), HttpStatus.OK);
    }
   @GetMapping("/refreshtoken/{token}")
    public ResponseEntity<?> refreshtoken(@PathVariable("token") String jwt) throws Exception {
       DefaultClaims claims = (DefaultClaims) this.getAllClaimsFromToken(jwt);
       Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
       String token = jwtUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
       return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }


    public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
        Map<String, Object> expectedMap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            expectedMap.put(entry.getKey(), entry.getValue());
        }
        return expectedMap;
    }

}
