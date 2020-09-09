package test.tecnico.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

public class JsonUtil {
	
	private JsonUtil() {}
	
    public static byte[] toJson(Object objeto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(objeto);
    }

}
