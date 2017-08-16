package chemIntegration.jsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Code to test the JSON Format
 *
 */
public class MainClass {

	public static void main(String args[]) throws Exception {

		/*
		 * To Test parser is working correctly
		 */

		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setEmail("mf@enviance.com");
		user.setName(null);
		List<String> nameArray = new ArrayList<String>();

		nameArray.add(
				"localFilePath : D://inetpub//wwwroot//devfrost-apandey//ExtApps//api//ChemIntegration//JSONFeedFileRepository//elsevier_jsonFeed_batch1.json---->ftp path : /elsevier/elsevier_jsonFeed_batch1.json");
		nameArray.add(
				"ï¼ˆç™½è‰²éžç²‰æœ«ï¼‰åŠè‡´ç™Œç‰©è´¨   æŸ¥æ‰¾â€œè‡´ç™Œç‰©è´¨â€+â€œç™½è‰²â€ï¼Œä½†éžâ€œç²‰æœ«â€");
		user.setListDetail(nameArray);
		users.add(user);
		users.add(user);

		JsonParser ob = new JsonParser();

		StringBuilder str = new StringBuilder();

		try {
			str = ob.toJSON(users);
			System.out.println(str);
		} catch (Exception ex) {
			System.out.println("not able to parse " + ex.getMessage());
		}

	}
}
