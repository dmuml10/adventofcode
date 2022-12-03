package ge.dm.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JReader {

    public static List<String> ReadFileAsString(String fileName) {
        List<String> result = null;
        try {
            try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
                result = lines.collect(Collectors.toList());
            }
        } catch (IOException ex) {
            // ignore
        }
        return result;
    }

}
