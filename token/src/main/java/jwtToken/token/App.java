package jwtToken.token;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jwtToken.token.domain.Auth;
import jwtToken.token.domain.TokenInfo;

/**
 * 
 * To test token working
 *
 */

public class App {
	
	public static void main(String[] args) {
		
		Token token = new Token();
		Auth auth = new Auth();
		auth.setEmail("ax@y.com");
		auth.setName("ax");
		auth.setExpirationTime((long) 200);
		auth.setUuId("12345678");
		auth.setSecret("amit");

		TokenInfo tokenObj = new TokenInfo();

		ObjectMapper mapper = new ObjectMapper();

		ObjectWriter writer = mapper.writer();

		writer = writer.withDefaultPrettyPrinter();

		try {
			String json = writer.writeValueAsString(auth);
			String tokenValue = token.generateCFToken(json);
			System.out.println(tokenValue);
			
			tokenObj.setToken(tokenValue);
			tokenObj.setSecret(auth.getSecret());
			tokenObj.setExpiration(auth.getExpirationTime());
			//
			String tokenStr = writer.writeValueAsString(tokenObj);
			System.out.println();
			System.out.println(token.getCFClaimsFromToken(tokenStr));
			
			System.out.println(token.isTokenExpired(tokenStr));
			System.out.println(token.getExpirationDateFromToken(tokenStr));
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
