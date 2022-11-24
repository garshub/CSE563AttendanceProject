


public class AttendanceProjectRunner {


    public static void main(String[] args) {
        LoadRoaster loadRoaster=new LoadRoaster();
        AddAttendance addAttendance= new AddAttendance();
        SaveFile saveFile= new SaveFile();
        PlotData plotData= new PlotData();
        new Gui(loadRoaster,addAttendance,saveFile,plotData);
    }
}
