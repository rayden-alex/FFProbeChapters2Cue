package by.rayden.ffprobechapters2cue;

import by.rayden.ffprobechapters2cue.ffprobe.FFProbeMetadata;
import tools.jackson.databind.json.JsonMapper;

import java.io.Reader;

public class FFProbeTransformer {
    final JsonMapper mapper;

    public FFProbeTransformer(JsonMapper mapper) {
        this.mapper = mapper;
    }

    public FFProbeMetadata getMetadata(final Reader reader) {
        return this.mapper.readValue(reader, FFProbeMetadata.class);
    }

}
