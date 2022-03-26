package modular.xml.serializer.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import modular.xml.serializer.api.IXmlSerializer;

public class JaxbXmlSerializer<T> implements IXmlSerializer<T> {

	@Override
	public String serialize(T instance, Class< ? extends T> clazz) {
		try {
			var outputStream = new ByteArrayOutputStream();
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(instance, outputStream);
			var inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			return IOUtils.toString(inputStream, Charset.defaultCharset());			
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
