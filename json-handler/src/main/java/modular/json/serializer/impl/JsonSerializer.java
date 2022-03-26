package modular.json.serializer.impl;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import modular.json.serializer.api.IJsonSerializer;

public class JsonSerializer<T> implements IJsonSerializer<T> {

	@Override
	public String serialize(T instance) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writerWithDefaultPrettyPrinter()
									  .writeValueAsString(instance);
			return jsonResult;
		} catch ( IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
