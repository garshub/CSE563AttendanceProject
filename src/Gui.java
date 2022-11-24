
import javax.swing.*;
import java.io.FileNotFoundException;


public class Gui  {
    JMenuBar menuBar;
    JMenu file;
    JMenu about;


    public Gui(LoadRoaster loadRoaster,AddAttendance addAttendance,SaveFile saveFile,PlotData plotData) {

        MenuActions menuActions=new MenuActions();
        JFrame f = new JFrame(Constants.APP_NAME);
        menuBar = new JMenuBar();
        file = new JMenu(Constants.FILE);
        about = new JMenu(Constants.ABOUT);
        JMenuItem[] fileItems = new JMenuItem[4];
        fileItems[0] = new JMenuItem(Constants.LOAD_ROASTER);
        fileItems[1] = new JMenuItem(Constants.ADD_ATTENDANCE);
        fileItems[2] = new JMenuItem(Constants.SAVE_FILE);
        fileItems[3] = new JMenuItem(Constants.PLOT_DATA);
        fileItems[1].setEnabled(false);



        fileItems[0].addActionListener(e ->{
            String path=menuActions.getFilePath(f);
            try {
                loadRoaster.load(path);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            fileItems[1].setEnabled(true);}
        );
        fileItems[1].addActionListener(e -> addAttendance.loadAttendace());
        fileItems[2].addActionListener(e -> saveFile.saveFileToFolder());
        fileItems[3].addActionListener(e -> plotData.plotChart());

        for(int i=0; i<4;i++){
            file.add(fileItems[i]);
        }

        menuBar.add(file);
        menuBar.add(about);
        f.setJMenuBar(menuBar);
        f.setSize(700, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
