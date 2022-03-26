package modular.xml.factory;

import modular.xml.deserializer.api.IXmlDeserializer;
import modular.xml.deserializer.impl.JaxbXmlDeserializer;

public class XmlDeserializerFactory<T> {
	
	public static<T> IXmlDeserializer<T> getInstance() {
		return new JaxbXmlDeserializer<T>();
	}
}
