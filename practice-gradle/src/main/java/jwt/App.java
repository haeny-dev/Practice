package jwt;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class App {
    public static void main(String[] args) {

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String secretString = Encoders.BASE64.encode(key.getEncoded());

        System.out.println("secretString = " + secretString);

        // Signed JWTs
        String jws = Jwts.builder()
                .setSubject("Bob")
                .signWith(key)
                .compact();

        System.out.println("jws = " + jws);

        jws = Jwts.builder()
                .setHeaderParam("kid", "myKeyId")
                .setSubject("Bob")
                .signWith(key)
                .compact();

        System.out.println("jws = " + jws);

//        Header header = Jwts.header();

        jws = Jwts.builder()
                .setHeaderParam("kid", "myKeyId")
                .setIssuer("me")
                .setSubject("Bob")
                .setAudience("you")
                .setIssuedAt(new Date())
                .setId(String.valueOf(UUID.randomUUID()))
                .claim("hello", "world")
                .signWith(key)
                .compact();

        System.out.println("jws = " + jws);
    }

    private static void quick_start() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws = Jwts.builder()
                .setSubject("Joe")
                .signWith(key)
                .compact();

        System.out.println("jws = " + jws);

        assert Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws)
                .getBody()
                .getSubject().equals("Joe");
    }
}
