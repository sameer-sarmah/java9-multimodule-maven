package modular.core;

import java.util.Optional;

public interface IContentSearch {
    Optional<String> search(String document,String searchString,ContentType contentType);
}
