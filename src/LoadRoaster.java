

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class LoadRoaster{

    public void load(String path) throws FileNotFoundException {
        System.out.println(path);
        File myObj = new File(path);
        Scanner myReader = new Scanner(myObj);
        String[] cols={"ID","FirstName","LastName","ASURITE"};
        for(String s:cols) {
            Data.getInstance().addColum(s);
        }
        int rowNum=0;
        int colsNum=0;

        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(",");
            for(String d:data){
                Data.getInstance().setTabelData(rowNum,colsNum,d);
                colsNum+=1;
                // here we can throw warning if we have non required Data
                if (colsNum==4){
                    //
                    break;
                }

            }
            rowNum+=1;
            colsNum=0;
            System.out.print(" \n");
        }

        int totalRows=3;
        for(rowNum=0;rowNum<totalRows;rowNum++){
            for(colsNum=0;colsNum<5;colsNum++){

                System.out.print(Data.getInstance().getTabelData(rowNum,colsNum)+" ");
            }
            System.out.println();
        }

    }

}
