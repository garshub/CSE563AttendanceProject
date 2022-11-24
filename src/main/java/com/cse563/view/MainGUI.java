package com.cse563.view;

import com.cse563.controller.AttendanceController;
import com.cse563.model.Model;
import com.cse563.utility.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu file;
    JMenu about;
    JMenuItem loadRoaster, addAttendance, saveData, plotData;
    JPanel jPanel;
    JTable jTable;

    public MainGUI() {
        this.setName(Constants.APP_NAME);
        menuBar = new JMenuBar();
        file = new JMenu(Constants.FILE);
        about = new JMenu(Constants.ABOUT);
        loadRoaster = new JMenuItem(Constants.LOAD_ROASTER);
        addAttendance = new JMenuItem(Constants.ADD_ATTENDANCE);
        saveData = new JMenuItem(Constants.SAVE_FILE);
        plotData = new JMenuItem(Constants.PLOT_DATA);

        loadRoaster.addActionListener(this);
        addAttendance.addActionListener(this);

        file.add(loadRoaster);
        file.add(addAttendance);
        file.add(saveData);
        file.add(plotData);
        menuBar.add(file);
        menuBar.add(about);
        jPanel = new JPanel(new BorderLayout());
        jTable = new JTable();
        this.setJMenuBar(menuBar);
        this.setSize(700, 400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals(Constants.ADD_ATTENDANCE)){
            new AttendanceController().addAttendance();
            DefaultTableModel model = new DefaultTableModel();
            Model.getInstance().listOfAttendance.forEach(dataPair -> {
                model.addColumn(dataPair.getDate());
            });
        }
    }

}
