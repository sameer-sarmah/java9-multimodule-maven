package modular.json.factory;

import modular.json.deserializer.api.IJsonDeserializer;
import modular.json.deserializer.impl.JsonDeserializer;

public class JsonDeserializerFactory<T> {
	
	public static<T> IJsonDeserializer<T> getInstance() {
		return new JsonDeserializer<T>();
	}
}
