package modular.json.factory;

import modular.json.serializer.api.IJsonSerializer;
import modular.json.serializer.impl.JsonSerializer;

public class JsonSerializerFactory {
	public static<T> IJsonSerializer<T> getInstance() {
		return new JsonSerializer<T>();
	}
}
