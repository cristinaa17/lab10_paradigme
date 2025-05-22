package main.java.main;
import main.java.storage.DataRepository;
import main.java.storage.SensorData;
import main.java.storage.DataAggregator;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Choose a strategy: type 'basic or 'filtered'");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataAggregator aggregator = new DataAggregator(Utils.getStrategy(strategyType));


        long baseTimestamp = System.currentTimeMillis();

        DataRepository dataRepository=DataRepository.getInstance();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));

        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));

        System.out.println("====================================================");
        aggregator.receive(dataRepository);
        System.out.println( aggregator.getResults());
        System.out.println("====================================================");

    }
}
