package until;

import java.sql.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	  private static String secret = "your_secret_key";

	    public String generateToken(String username) {
	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date(0))
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
	                .signWith(SignatureAlgorithm.HS256, secret)
	                .compact();
	    }

	    public static Claims extractClaims(String token) {
	        return Jwts.parser()
	                .setSigningKey(secret)
	                .parseClaimsJws(token)
	                .getBody();
	    }

	    public boolean validateToken(String token, String username) {
	        return username.equals(extractClaims(token).getSubject()) && !isTokenExpired(token);
	    }

	    private boolean isTokenExpired(String token) {
	        return extractClaims(token).getExpiration().before(new Date(0));
	    }
}
