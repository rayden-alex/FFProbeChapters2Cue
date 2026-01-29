package by.rayden.ffprobe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public record Metadata(
    @JsonProperty("chapters")
    List<ChaptersItem> chapters,

    @JsonProperty("streams")
    List<StreamsItem> streamsList,

    @JsonProperty("format")
    Format format) {

    @JsonCreator
    public Metadata(@JsonProperty("chapters") List<ChaptersItem> chapters,
                    @JsonProperty("streams") List<StreamsItem> streamsList,
                    @JsonProperty("format") Format format) {
        this.chapters = Objects.requireNonNullElseGet(chapters, Collections::emptyList);
        this.streamsList = Objects.requireNonNullElseGet(streamsList, Collections::emptyList);
        this.format = format;
    }

}
