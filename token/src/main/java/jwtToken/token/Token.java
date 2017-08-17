package jwtToken.token;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jwtToken.token.domain.Auth;
import jwtToken.token.domain.TokenInfo;

/**
 * To Parse and Unparse JsonWebToken
 */
public class Token {

	static final String CLAIM_KEY_USEREMAIL = "sub";
	static final String CLAIM_KEY_USERNAME = "name";
	static final String CLAIM_KEY_USERID = "uuid";
	static final String CLAIM_KEY_AUDIENCE = "audience";
	static final String CLAIM_KEY_CREATED = "created";

	/**
	 * 
	 * @param token
	 * @param secret
	 * @return Claims
	 */
	public Claims getClaimsFromToken(String tokenInfo) {
				
		Claims claims;
		try {
			TokenInfo tokenObj = generateCFTokenInfo(tokenInfo);
			claims = Jwts.parser().setSigningKey(tokenObj.getSecret()).parseClaimsJws(tokenObj.getToken()).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return claims;
	
	}
	
	public String getCFClaimsFromToken(String tokenInfo) throws JsonParseException, JsonMappingException, IOException{
		Claims claims = getClaimsFromToken(tokenInfo);
		
		return toStringObj(claims);
		
	}

	/**
	 * 
	 * @param token
	 * @param secret
	 * @return String
	 */
	public String getUsernameFromToken(String tokenInfo) {
		String username;
		try {
			final Claims claims = getClaimsFromToken(tokenInfo);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	/**
	 * 
	 * @param token
	 * @param secret
	 * @return Date
	 */
	public Date getCreatedDateFromToken(String tokenInfo) {
		Date created;
		try {
			final Claims claims = getClaimsFromToken(tokenInfo);
			created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
		} catch (Exception e) {
			created = null;
		}
		return created;
	}

	/**
	 * 
	 * @param obj
	 * @return String
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private String toStringObj(Object obj) throws JsonParseException, JsonMappingException, IOException {

		try {

			ObjectMapper mapper = new ObjectMapper();

			ObjectWriter writer = mapper.writer();

			writer = writer.withDefaultPrettyPrinter();

			String json = writer.writeValueAsString(obj);

			return json;
		} catch (Exception e) {
			throw new IOException("Error in parsing file " + e.getMessage());
		}
	}
	
	/**
	 * @param expiration
	 * @return Date
	 */
	private Date generateExpirationDate(Long expiration) {
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}

	/**
	 * 
	 * @param userDetails
	 * @return String
	 */
	private String generateToken(Auth userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(CLAIM_KEY_USEREMAIL, userDetails.getEmail());
		claims.put(CLAIM_KEY_CREATED, new Date());
		claims.put(CLAIM_KEY_USERNAME, userDetails.getName());
		claims.put(CLAIM_KEY_USERID, userDetails.getUuId());
		return generateToken(claims, userDetails.getExpirationTime(), userDetails.getSecret());
	}

	/**
	 * 
	 * @param userDetails
	 * @return String
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String generateCFToken(String userDetails) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		Auth authInfo= mapper.readValue(userDetails, Auth.class);

		return generateToken(authInfo);
	}

	/**
	 * 
	 * @param claims
	 * @param expiration
	 * @param secret
	 * @return String
	 */
	private String generateToken(Map<String, Object> claims, Long expiration, String secret) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate(expiration))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	/**
	 * 
	 * @param tokenInfo
	 * @return TokenInfo
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private TokenInfo generateCFTokenInfo(String tokenInfo) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		TokenInfo token= mapper.readValue(tokenInfo, TokenInfo.class);

		return token;
	}

	/**
	 * 
	 * @param token
	 * @return String
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String refreshToken(String tokenInfo) throws JsonParseException, JsonMappingException, IOException {
		String refreshedToken;
		TokenInfo tokenObj = generateCFTokenInfo(tokenInfo);
		try {
			final Claims claims = getClaimsFromToken(tokenInfo);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = generateToken(claims, tokenObj.getExpiration(), tokenObj.getSecret());
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}
	
	/**
	 * 
	 * @param tokenInfo
	 * @return Boolean
	 */
	public Boolean isTokenExpired(String tokenInfo) {
		final Date expiration = getClaimsFromToken(tokenInfo).getExpiration();
		return expiration.before(new Date());
	}
	
	/**
	 * 
	 * @param tokenInfo
	 * @return Date
	 */
	public Date getExpirationDateFromToken(String tokenInfo) {
		
		Date expiration = getClaimsFromToken(tokenInfo).getExpiration();

		return expiration;
	}
}
