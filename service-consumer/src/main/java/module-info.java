module service.consumer{
	requires json.handler;
	requires xml.handler;
	requires jakarta.xml.bind;
	opens modular.json.consumer to jackson.databind;
	opens modular.xml.consumer to jakarta.xml.bind;
	requires modular.core;
	uses modular.core.IContentSearch;
	requires commons.collections4;
}