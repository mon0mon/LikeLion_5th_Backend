/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-07 PM 3:31
 */

package com.example.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.sql.Date;
import java.time.Instant;

//  JWT 관련 기능들을 넣어두기 위한 기능성 클래스
@Slf4j
@Component
public class JwtTokenUtils {
    //  JWT는 암호화를 거쳐서 만들어지는데,
    //  이를 위해서 암호키가 필요하다.
    private final Key signingKey;
    private final JwtParser jwtParser;

    public JwtTokenUtils(@Value("${jwt.secret}") String jwtSecret) {
//        this.signingKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        this.signingKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        this.jwtParser = Jwts
                .parserBuilder()
                .setSigningKey(signingKey)
                .build();
    }

    //  1. JWT가 유효한지 판단하는 메소드
    //      jjwt 라이브러리에서는 JWT를 해석하는 과정에서 유효하지 않으면 예외 발생
    public boolean validation(String token) {
        //  정당한 JWT면 true,
        try {
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
        //  정당하지 않은 JWT면 false
            log.warn("invalid jwt: {}", e.getClass());
            return false;
        }
    }

    //  JWT를 인자로 받고, 그 JWT를 해석해서 사용자 정보를 회수하는 메소드
    public Claims parseClaims(String token) {
        return jwtParser
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        //  Claims : JWT에 담길 데이터의 키 (맵의 키와 비슷한 용도)
        //  이부분은 JWT에 담고 싶은 사용자 정보를 담는다.
        Claims jwtClaims = Jwts.claims()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(3600)));

        //  추가 정보를 담을수도 있다.
//        jwtClaims.put("email", ((CustomUserDetails) userDetails).getEmail());

        return Jwts.builder()
                .setClaims(jwtClaims)
                .signWith(signingKey)
                .compact();
    }
}
