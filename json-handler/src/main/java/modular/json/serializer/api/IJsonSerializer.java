package modular.json.serializer.api;

public interface IJsonSerializer<T> {
	
	String serialize(T instance);
}
