module xml.handler {
	exports modular.xml.serializer.api;
	exports modular.xml.deserializer.api;
	exports modular.xml.factory;
	exports modular.xml.runner;
	exports modular.xml.serializer.impl;
	exports modular.xml.deserializer.impl;
	requires jakarta.xml.bind;
	requires org.apache.commons.io;
	opens modular.xml.runner to jakarta.xml.bind;

}