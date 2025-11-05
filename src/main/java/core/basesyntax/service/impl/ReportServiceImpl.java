package core.basesyntax.service.impl;

import core.basesyntax.CalculateAvailableFruits;
import core.basesyntax.ReportGenerator;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final ReportGenerator reportGenerator = new CalculateAvailableFruits();

    public String createReport(List<FruitTransaction> fileData) {
        return this.reportGenerator.generate(fileData);
    }
}
