package by.rayden;

import by.rayden.ffprobe.Metadata;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.InputStreamReader;

public class FFProbeTransformer {
    final JsonMapper mapper;

    public FFProbeTransformer() {
        this.mapper = JsonMapper
            .builder()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
            .build();
    }

    public Metadata getMetadata(final InputStreamReader reader) {
        return this.mapper.readValue(reader, Metadata.class);
    }
}
