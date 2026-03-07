package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ExcelReader implements DataSource {

    private final Path filePath;

    private final int cellIndex;
    private final int sheetIndex;
    private Workbook workbook;
    private final DataFormatter dataFormatter = new DataFormatter();

    public ExcelReader(String filePath, int cellIndex, int sheetIndex) {
        this.filePath = Path.of(filePath);
        this.cellIndex = cellIndex;
        this.sheetIndex = sheetIndex;
    }

    @Override
    public Stream<String> readValues() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePath.toFile());
        workbook = new XSSFWorkbook(fileInputStream);

        Sheet sheet = workbook.getSheetAt(sheetIndex);

        return StreamSupport.stream(sheet.spliterator(), false)
                .map(this::readCell)
                .filter(Objects::nonNull);
    }

    private String readCell(Row row) {
        Cell cell = row.getCell(cellIndex);

        if (cell == null) {
            return null;
        }

        return dataFormatter.formatCellValue(cell);
    }

    @Override
    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
