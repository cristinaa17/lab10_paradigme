package main.java.storage;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Persists sensor data.
 */
public class DataRepository {

    private List<SensorData> dataRecords = new ArrayList<>();
    private static DataRepository instance=null;

    public DataRepository(){

    }
    public static DataRepository getInstance(){
        if(instance==null){
            instance=new DataRepository();
        }
        return instance;
    }
    public void addData(SensorData dataRecord){
       dataRecords.add(dataRecord);
    }

    public List<SensorData> getRecords() {
        return dataRecords;
    }
}


