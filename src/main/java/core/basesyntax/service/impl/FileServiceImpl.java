package core.basesyntax.service.impl;

import core.basesyntax.CsvFileReader;
import core.basesyntax.CsvFileWriter;
import core.basesyntax.FileDataReader;
import core.basesyntax.FileDataWriter;
import core.basesyntax.service.FileService;
import java.util.List;

public class FileServiceImpl implements FileService {
    private final FileDataReader fileDataReader = new CsvFileReader();
    private final FileDataWriter fileDataWriter = new CsvFileWriter();

    @Override
    public List<String> read(String filePath) {
        return this.fileDataReader.read(filePath);
    }

    @Override
    public void write(String filePath, String data) {
        this.fileDataWriter.write(filePath, data);
    }
}
