package Util;

import Daemon.GriddableCreator;
import Daemon.SerializableGridderCreator;
import Resource.UIManager;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class SaveFile {
    public static void SaveProject(){
        FileChooser choose = new FileChooser();
        choose.setTitle("Save the project. The associated TableGEN is automatically saved in the same position");
        choose.setInitialDirectory(new File("./"));
        File file = choose.showSaveDialog(UIManager.getInstance().getTableStage());
        ObservableList<GriddableCreator> saveTable =  UIManager.getInstance().getTable().obtainTable();
        List<SerializableGridderCreator> table = new ArrayList<>();
        for(GriddableCreator el: saveTable){
            table.add(new SerializableGridderCreator(el));
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath() + ".cbman"));
            out.writeObject(table);
   //         out.putFields()
            out.close();
            out = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath() + "1.cbman" ));
            out.writeObject(UIManager.getInstance().getGrid().obtainGrid());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
