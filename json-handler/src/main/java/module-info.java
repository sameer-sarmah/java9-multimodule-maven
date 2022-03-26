module json.handler{
	exports modular.json.serializer.api;
	exports modular.json.serializer.impl;
	exports modular.json.deserializer.api;
	exports modular.json.deserializer.impl;
	exports modular.json.factory;
	requires transitive  jackson.core;
	requires transitive  jackson.annotations;
	requires transitive  jackson.databind;
	opens modular.json.runner to jackson.databind;
}