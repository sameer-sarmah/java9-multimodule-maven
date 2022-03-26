package modular.xml.serializer.api;

public interface IXmlSerializer<T> {
	
	String serialize(T instance, Class< ? extends T> clazz);
}
