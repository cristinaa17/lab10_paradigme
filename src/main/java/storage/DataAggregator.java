package main.java.storage;
import main.java.dataprocessing.StepCountStrategy;

public class DataAggregator  {
    private StepCountStrategy strategy;
    public DataAggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }
    public void receive(DataRepository repo) {
        repo.getRecords().forEach(strategy::consumeMessage);
    }


    public String getResults() {
        return String.format("Strategy %s: stepsCount=%d", strategy.getStrategyDescription(), strategy.getTotalSteps());
    }
}
