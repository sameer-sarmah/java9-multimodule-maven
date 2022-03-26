package modular.xml.deserializer.impl;

import java.io.StringReader;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import modular.xml.deserializer.api.IXmlDeserializer;

public class JaxbXmlDeserializer<T> implements IXmlDeserializer<T>  {

	@Override
	public T deserialize(String xml, Class<? extends T> clazz) {
		   try {
	            JAXBContext context = JAXBContext.newInstance(clazz);
	            Unmarshaller unmarshaller = context.createUnmarshaller();
	            unmarshaller.setAdapter(new NormalizedStringAdapter());
	            Object o = unmarshaller.unmarshal(new StringReader(xml));
	            return clazz.cast(o);
	        } catch(Exception e) {
	            throw new IllegalStateException("Error while deserializing a XML text to Object of type " + clazz, e);
	        }
	}

}
