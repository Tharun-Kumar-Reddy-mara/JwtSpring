package com.example.WingsProgram.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final String secretKey = "Secretkey123456789HfsgBJHJIKSsfsfvdbdkd154884545fr4f7";

    public String GenerateToken(String name){
        Map<String,Object> claims= new HashMap<>();
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(name)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60*60*30))
                .signWith(getKey())
                .compact();
    }

    public Claims ExtractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

    public <T> T ExtractClaim(String token,Function<Claims,T> claimResolver){
        final Claims claims = ExtractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public Date getExpirationDate(String token){
        return ExtractClaim(token,Claims::getExpiration);
    }

    public String getUserName(String token){
        return ExtractClaim(token,Claims::getSubject);
    }

    public Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isTokenExpired(String token){
        return getExpirationDate(token).before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUserName(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

}
