package com.cse563.controller;

import com.cse563.model.DataPair;
import com.cse563.model.Model;
import com.cse563.view.CustomJFileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;import java.util.Scanner;

public class AttendanceController{

    public void addAttendance(){

        CustomJFileChooser fileChooser = new CustomJFileChooser();
        List<File> listOfFiles = fileChooser.getAllFiles();
        System.out.println(listOfFiles.size());

        listOfFiles.forEach(file -> {
            try {
                Scanner scanner = new Scanner(file);
                scanner.useDelimiter("\r");
                HashMap<String, Integer> map = new HashMap<>();
                while(scanner.hasNext()){
                    String[] row = scanner.next().trim().split(",");
                    String asurite = row[0];
                    Integer mins = Integer.valueOf(row[1]);
                    //MergeAttendance
                    map.put(asurite, map.getOrDefault(asurite, 0) + mins);
                 }
                String date = file.getName().substring(0, 8);
                Model.getInstance().listOfAttendance.add(new DataPair(date, map));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        });
    }
}
