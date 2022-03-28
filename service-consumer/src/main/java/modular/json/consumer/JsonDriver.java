package modular.json.consumer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import modular.core.ContentType;
import modular.core.IContentSearch;
import modular.json.deserializer.api.IJsonDeserializer;
import modular.json.factory.JsonDeserializerFactory;
import modular.json.factory.JsonSerializerFactory;
import modular.json.serializer.api.IJsonSerializer;
import org.apache.commons.collections4.IteratorUtils;

public class JsonDriver {

	public static void main(String[] args) throws IOException {
		String serializedJson = serialize();
		deserialize(serializedJson);
		ServiceLoader<IContentSearch> services = ServiceLoader.load(IContentSearch.class);
		Iterator<IContentSearch> it = services.iterator();
		List<IContentSearch> searchServices = IteratorUtils.toList(it);
		searchServices.stream().forEach(svc -> {
			System.out.println(svc.search(serializedJson,"$.name", ContentType.JSON));
		});
	}
	
	private static String serialize() {
		IJsonSerializer<Book> serializer = JsonSerializerFactory.<Book>getInstance();
		var book = new Book(1L,"Microservices","Sam Newman");
		String serializedXml = serializer.serialize(book);
		System.out.println(serializedXml);
		return serializedXml;
	}
	
	private static void deserialize(String xml) {
		IJsonDeserializer<Book> deserializer = JsonDeserializerFactory.getInstance();
		Class<Book> clazz = Book.class;
		Book book = deserializer.deserialize(xml, clazz);
		System.out.println(book);
	}

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
