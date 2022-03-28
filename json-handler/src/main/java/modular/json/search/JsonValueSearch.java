package modular.json.search;

import com.jayway.jsonpath.JsonPath;
import modular.core.ContentType;
import modular.core.IContentSearch;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class JsonValueSearch implements IContentSearch {
    @Override
    public Optional<String> search(String document,String jsonPath, ContentType contentType) {
        if(contentType.equals(ContentType.JSON) && !StringUtils.isEmpty(jsonPath) && !StringUtils.isEmpty(document)){
            return Optional.of(JsonPath.parse(document).read(jsonPath));
        }
        return Optional.empty();
    }
}
