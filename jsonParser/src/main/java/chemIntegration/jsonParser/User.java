package chemIntegration.jsonParser;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1148960768881041239L;

	private String name;
	
	private String email;
	
	private List<String> listDetail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<String> listDetail) {
		this.listDetail = listDetail;
	}
	
}
