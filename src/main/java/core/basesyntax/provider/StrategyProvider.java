package core.basesyntax.provider;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyProvider {
    private final Map<Operation, OperationStrategy> strategyMap = new HashMap<>();

    public StrategyProvider() {
        this.strategyMap.put(Operation.RETURN, new ReturnOperation());
        this.strategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        this.strategyMap.put(Operation.BALANCE, new BalanceOperation());
        this.strategyMap.put(Operation.SUPPLY, new SupplyStrategy());
    }

    public OperationStrategy get(Operation operation) {
        return this.strategyMap.get(operation);
    }
}
