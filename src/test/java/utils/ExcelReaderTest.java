package utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcelReaderTest {

    @Test
    public void testReadValues() throws IOException {

        DataSource dataSource = new ExcelReader("sample-data/vzorek_dat.xlsx", 1, 0);

        List<String> values = dataSource.readValues()
                .toList();

        assertEquals(20, values.size());
        assertEquals("Data", values.get(0));
    }
}
