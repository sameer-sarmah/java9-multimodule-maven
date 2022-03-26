package modular.json.deserializer.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import modular.json.deserializer.api.IJsonDeserializer;

public class JsonDeserializer<T> implements IJsonDeserializer<T>  {

	@Override
	public T deserialize(String json, Class<? extends T> clazz) {
		   try {
			   ObjectMapper mapper = new ObjectMapper();
			   mapper.readValue(json.getBytes(), clazz);
	            return mapper.readValue(json.getBytes(), clazz);
	        } catch(Exception e) {
	            throw new IllegalStateException("Error while deserializing a Json text to Object of type " + clazz, e);
	        }
	}

}
