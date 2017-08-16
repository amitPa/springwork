package chemIntegration.jsonParser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/*
 * Class to beautify JSON code
 */
public class JsonParser {

	/**
	 * To return formatted JSON output from Object input
	 * @param obj
	 * @return String
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public StringBuilder toJSON(Object obj) throws JsonParseException, JsonMappingException, IOException {

		try {

			ObjectMapper mapper = new ObjectMapper();

			ObjectWriter writer = mapper.writer();

			writer = writer.withDefaultPrettyPrinter();

			StringBuilder json = new StringBuilder(writer.writeValueAsString(obj));

			return json;
		} catch (Exception e) {
			throw new IOException("Error in parsing file " + e.getMessage());
		}
	}

	/**
	 * To return formatted JSON from serialized input
	 * @param inputJson
	 * @return StringBuilder
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public StringBuilder toJSONFromString(String inputJson)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		List<Object> map = mapper.readValue(inputJson, List.class);

		return toJSON(map);

	}

	/**
	 * To test JsonParser is working
	 * @return String
	 */
	public String returnString() {
		return "Test Json Parser";
	}

}
