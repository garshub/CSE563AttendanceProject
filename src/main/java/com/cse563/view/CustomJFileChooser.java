package com.cse563.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomJFileChooser extends JFrame{

    JFileChooser jFileChooser;

    public CustomJFileChooser(){

        System.out.println("In Custom File Chooser");
        jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jFileChooser.setDialogTitle("Select csv files");
        jFileChooser.setMultiSelectionEnabled(true);
        jFileChooser.setAcceptAllFileFilterUsed(false);
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setBounds(100, 100, 400, 400);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV only", "csv");
        jFileChooser.addChoosableFileFilter(filter);
        jFileChooser.setVisible(true);
    }

    public List<File> getAllFiles(){
        List<File> listOfFiles = new ArrayList<>();
        int returnValue = jFileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File[] files = jFileChooser.getSelectedFiles();
            Arrays.asList(files).forEach(x -> {
                if (x.isFile()) {
                    listOfFiles.add(x);
                }
            });
        }
        return listOfFiles;
    }
}
