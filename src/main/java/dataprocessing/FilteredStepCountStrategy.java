package main.java.dataprocessing;
import main.java.storage.SensorData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteredStepCountStrategy implements StepCountStrategy {

    private final List<SensorData> history = new ArrayList<>();
    private int totalSteps=0;

    /*@Override
    public void consumeMessage(SensorData sample) {
        if(sample.getStepsCount()>0) {
            totalSteps+=sample.getStepsCount();
        }
    }*/

    @Override
    public void consumeMessage(SensorData sample) {
        if (sample.getStepsCount() <= 0) {
            return;
        }
        history.add(sample);

        long oneMinuteAgo = System.currentTimeMillis() - 60000;

        List<SensorData> lastMinuteList = history.stream()
                .filter(r -> r.getTimestamp() >= oneMinuteAgo)
                .collect(Collectors.toList());

        int lastMinuteSteps = lastMinuteList.stream()
                .mapToInt(SensorData::getStepsCount)
                .sum();

        if (lastMinuteSteps <= 1000) {
            totalSteps += sample.getStepsCount();
        }
    }

    @Override
    public int getTotalSteps() {
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        //return "Strategie care numara pasii filtrati";
        return "Strategie care numara pasii pozitivi dacă <1000 în ultimul minut";
    }
}
