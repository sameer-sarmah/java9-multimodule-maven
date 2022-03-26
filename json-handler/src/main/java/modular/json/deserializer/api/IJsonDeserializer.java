package modular.json.deserializer.api;

public interface IJsonDeserializer<T> {
	T deserialize(String xml, Class< ? extends T> clazz);
}
