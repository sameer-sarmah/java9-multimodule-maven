package modular.xml.runner;

import java.io.IOException;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.XmlRootElement;
import modular.core.ContentType;
import modular.xml.deserializer.impl.JaxbXmlDeserializer;
import modular.xml.search.XmlValueSearch;
import modular.xml.serializer.impl.JaxbXmlSerializer;

public class Driver {

	public static void main(String[] args) throws JAXBException, IOException {
		String serializedXml = serialize();
		deserialize(serializedXml);
		System.out.println(new XmlValueSearch().search(serializedXml,"//author[(contains(.,'Sam Newman'))]", ContentType.XML));
	}
	
	private static String serialize() {
		JaxbXmlSerializer<Book> serializer = new JaxbXmlSerializer<>();
		var book = new Book(1L,"Microservices","Sam Newman");
		Class<Book> clazz = Book.class;
		String serializedXml = serializer.serialize(book, clazz);
		System.out.println(serializedXml);
		return serializedXml;
	}
	
	private static void deserialize(String xml) {
		JaxbXmlDeserializer<Book> deserializer = new JaxbXmlDeserializer<>();
		Class<Book> clazz = Book.class;
		Book book = deserializer.deserialize(xml, clazz);
		System.out.println(book);
	}

	@XmlRootElement
	static class Book {
	    private Long id;
	    private String name;
	    private String author;
	    	    
		public Book() {
			super();
		}

		public Book(Long id, String name, String author) {
			super();
			this.id = id;
			this.name = name;
			this.author = author;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
		}	
	}
}
