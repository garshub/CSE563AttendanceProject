package com.cse563.view;

import com.cse563.utility.Constants;

import javax.swing.*;

public class MainGUI {

    JMenuBar menuBar;
    JMenu file;
    JMenu about;
    JMenuItem loadRoaster, addAttendance, saveData, plotData;

    public MainGUI() {
        JFrame f = new JFrame(Constants.APP_NAME);
        menuBar = new JMenuBar();
        file = new JMenu(Constants.FILE);
        about = new JMenu(Constants.ABOUT);
        loadRoaster = new JMenuItem(Constants.LOAD_ROASTER);
        addAttendance = new JMenuItem(Constants.ADD_ATTENDANCE);
        saveData = new JMenuItem(Constants.SAVE_FILE);
        plotData = new JMenuItem(Constants.PLOT_DATA);

        file.add(loadRoaster);
        file.add(addAttendance);
        file.add(saveData);
        file.add(plotData);
        menuBar.add(file);
        menuBar.add(about);
        f.setJMenuBar(menuBar);
        f.setSize(700, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
