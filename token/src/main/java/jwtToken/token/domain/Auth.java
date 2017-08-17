package jwtToken.token.domain;

public class Auth {

	private String name;
	
	private String uuId;
	
	private String email;
	
	private String secret;
	
	private Long expirationTime;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
}
