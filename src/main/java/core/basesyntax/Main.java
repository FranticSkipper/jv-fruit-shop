package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "src/main/resources/";
    private static final String READ_FILE_NAME = "fruits.txt";
    private static final String WRITE_FILE_NAME = "fruits_report.txt";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl(
                new CsvFileReader(),
                new CsvFileWriter()
        );
        DataParserService dataParser = new DataParserServiceImpl(
                new CsvDataParser()
        );
        ReportService reportService = new ReportServiceImpl(
                new CalculateAvailableFruits()
        );

        List<String> fileData = fileService.read(
                generateFilePath(READ_FILE_NAME)
        );
        List<FruitTransaction> parsedData = dataParser.parse(fileData);
        String reportData = reportService.createReport(parsedData);
        fileService.write(
                generateFilePath(WRITE_FILE_NAME),
                reportData
        );
    }

    private static String generateFilePath(String fileName) {
        return FILE_PATH + fileName;
    }
}
