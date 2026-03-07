package utils;

import java.io.IOException;
import java.util.stream.Stream;

public interface DataSource extends AutoCloseable {
    Stream<String> readValues() throws IOException;

    @Override
    void close() throws IOException;
}
