package rest.koios.client.backend.api.epoch.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.util.Map;

public class CostModelsDeserializer extends JsonDeserializer<Map<String, Map<String, Long>>> {

    @Override
    public Map<String, Map<String, Long>> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        TextNode textNode = objectCodec.readTree(jsonParser);
        return ((ObjectMapper) objectCodec).readValue(textNode.asText(), new TypeReference<>() {});
    }
}
