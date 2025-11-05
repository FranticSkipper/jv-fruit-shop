package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private static final String FILE_PATH = "src/main/resources/";
    private static final String READ_FILE_NAME = "fruits.txt";
    private static final String WRITE_FILE_NAME = "fruits_report.txt";
    private final FileService fileService = new FileServiceImpl();
    private final DataParserService dataParser = new DataParserServiceImpl();
    private final ReportService reportService = new ReportServiceImpl();

    public void process() {
        List<String> fileData = this.fileService.read(
                this.generateFilePath(READ_FILE_NAME)
        );
        List<FruitTransaction> parsedData = this.dataParser.parse(fileData);
        String reportData = this.reportService.createReport(parsedData);
        this.fileService.write(
                this.generateFilePath(WRITE_FILE_NAME),
                reportData
        );
    }

    private String generateFilePath(String fileName) {
        return FILE_PATH + fileName;
    }
}
