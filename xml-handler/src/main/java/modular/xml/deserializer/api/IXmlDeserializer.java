package modular.xml.deserializer.api;

public interface IXmlDeserializer<T> {
	T deserialize(String xml, Class< ? extends T> clazz);
}
