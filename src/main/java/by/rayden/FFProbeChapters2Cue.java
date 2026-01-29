package by.rayden;

import by.rayden.ffprobe.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FFProbeChapters2Cue {

    private static final Logger log = LoggerFactory.getLogger(FFProbeChapters2Cue.class);

    static void main() {

        Charset jsonCharset = StandardCharsets.UTF_8;

        // Read from PIPE
        InputStreamReader reader = new InputStreamReader(new BufferedInputStream(System.in), jsonCharset);

        try {
            FFProbeTransformer ffProbeTransformer = new FFProbeTransformer();
            Metadata ffProbeMetadata = ffProbeTransformer.getMetadata(reader);
            log.info("FFProbe JSON read successfully!");

            CueTransformer cueTransformer = new CueTransformer();
            String cue = cueTransformer.transformToCue(ffProbeMetadata);
            log.info("FFProbe JSON converted to CUE string");

            System.out.print(cue);
        } catch (Exception e) {
            log.error("FFProbe JSON converting error!");
        }
    }
}
