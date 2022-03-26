package modular.xml.factory;

import modular.xml.serializer.api.IXmlSerializer;
import modular.xml.serializer.impl.JaxbXmlSerializer;

public class XmlSerializerFactory {
	public static<T> IXmlSerializer<T> getInstance() {
		return new JaxbXmlSerializer<T>();
	}
}
