package com.cse563.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static Model singleInstance = null;
    public List<DataPair> listOfAttendance;

    private Model() {
        listOfAttendance = new ArrayList<>();
    }

    public static Model getInstance() {

        if (singleInstance == null) {
            singleInstance = new Model();
        }
        return singleInstance;
    }
}
