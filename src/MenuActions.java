
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Observable;

public class MenuActions {

    public String getFilePath(JFrame f){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text or CSV file", "csv", "CSV","txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(f);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return "";
    }
}
