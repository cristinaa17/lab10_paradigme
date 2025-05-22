package main.java.main;
import main.java.dataprocessing.BasicStepCountStrategy;
import main.java.dataprocessing.FilteredStepCountStrategy;
import main.java.dataprocessing.StepCountStrategy;

public class Utils {
    public static final String BASIC_STRATEGY = "basic";
    public static final String FILTERED_STRATEGY = "filtered";

    public static int getClientId() {
        return 42;
    }

    public static StepCountStrategy getStrategy(String type) {
        if (type.equals(BASIC_STRATEGY)) {
            return new BasicStepCountStrategy();
        } else if (type.equals(FILTERED_STRATEGY)) {
            return new FilteredStepCountStrategy();
        } else {
            throw new IllegalArgumentException("Unknown strategy: " + type);
        }
    }
}
