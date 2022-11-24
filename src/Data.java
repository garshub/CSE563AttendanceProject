import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class Data {
    private static Data instance = null;
    private Vector<String> columnNames = new Vector<String>();
    private Vector<Vector<String>> tabelData = new Vector<Vector<String>>();
    private int tabelRows=0;
    private int tabelCols=0;

    private Data() {
    }
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public void addColum(String name){
        columnNames.add(name);
    }

    public void setTabelData(int row,int col,String data){
        tabelRows=Math.max(tabelRows,row);
        tabelCols=Math.max(tabelCols,col);
        while(tabelData.size()<=row){
            addRow();
        }
        while(tabelData.elementAt(row).size()<=col){
            addCol(row);
        }
        tabelData.elementAt(row).insertElementAt(data,col);
    }
    private void addRow(){
        Vector<String> x=new Vector<>();
        tabelData.add(x);

    }

    /**
     * adding columns ot the given row to match input size
     * @param row
     */
    private void addCol(int row){
        String x="";
        tabelData.elementAt(row).add(x);

    }

    public String getTabelData(int row,int col){
        return tabelData.elementAt(row).elementAt(col);
    }

    public int getTabelRows(){
        return tabelRows;
    }

    public int getTabelCols(){
        return tabelCols;
    }

    public void resetTabel(){
        tabelData = new Vector<Vector<String>>();
    }


}
