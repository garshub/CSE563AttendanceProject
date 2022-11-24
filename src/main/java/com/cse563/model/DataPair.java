package com.cse563.model;

import java.util.HashMap;

public class DataPair {

    String date;
    HashMap<String, Integer> attendance;

    public DataPair(String date, HashMap<String, Integer> attendance) {
        this.date = date;
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashMap<String, Integer> getAttendance() {
        return attendance;
    }

    public void setAttendance(HashMap<String, Integer> attendance) {
        this.attendance = attendance;
    }
}
