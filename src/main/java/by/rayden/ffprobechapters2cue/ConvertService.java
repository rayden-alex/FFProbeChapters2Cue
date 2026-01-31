package by.rayden.ffprobechapters2cue;

import by.rayden.ffprobechapters2cue.ffprobe.FFProbeMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConvertService {
    private static final Logger log = LoggerFactory.getLogger(ConvertService.class);

    private final FFProbeTransformer ffProbeTransformer;
    private final CueTransformer cueTransformer;

    public ConvertService(FFProbeTransformer ffProbeTransformer, CueTransformer cueTransformer) {
        this.ffProbeTransformer = ffProbeTransformer;
        this.cueTransformer = cueTransformer;
    }

    public void convert(String inFileName, String outFileName) throws IOException {
        final boolean isReadFromStdIn = "-".equals(inFileName);
        final boolean isWriteToStdOut = "-".equals(outFileName);

        String cueStr;

        if (isReadFromStdIn) {
            Reader inReader = new BufferedReader(new InputStreamReader(System.in,
                System.getProperty("stdin.encoding")));
            cueStr = readFrom(inReader);
        } else {
            Path inFilePath = Path.of(inFileName);
            try (Reader inReader = Files.newBufferedReader(inFilePath)) {
                cueStr = readFrom(inReader);
            }
        }

        if (isWriteToStdOut) {
            System.out.print(cueStr);
        } else {
            Files.writeString(Path.of(outFileName), cueStr);
        }
    }

    private String readFrom(Reader reader) {
        try {
            FFProbeMetadata metadata = this.ffProbeTransformer.getMetadata(reader);
            log.info("FFProbe JSON read successfully!");

            String cue = this.cueTransformer.transformToCue(metadata);
            log.info("FFProbe JSON converted to CUE string");

            return cue;
        } catch (Exception e) {
            log.error("FFProbe JSON converting error!");
            throw e;
        }
    }

}
