package modular.json.runner;

import java.io.IOException;

import modular.json.deserializer.impl.JsonDeserializer;
import modular.json.serializer.impl.JsonSerializer;

public class Driver {

	public static void main(String[] args) throws IOException {
		deserialize(serialize());
	}
	
	private static String serialize() {
		JsonSerializer<Book> serializer = new JsonSerializer<>();
		var book = new Book(1L,"Microservices","Sam Newman");
		String serializedXml = serializer.serialize(book);
		System.out.println(serializedXml);
		return serializedXml;
	}
	
	private static void deserialize(String xml) {
		JsonDeserializer<Book> deserializer = new JsonDeserializer<>();
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
