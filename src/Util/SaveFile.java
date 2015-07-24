package Util;

import Daemon.GriddableCreator;
import Daemon.SerializableGridderCreator;
import Resource.UIManager;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class SaveFile {
    public static void SaveProject(String savefile){
        ObservableList<GriddableCreator> saveTable =  UIManager.getInstance().getTable().obtainTable();
        List<SerializableGridderCreator> table = new ArrayList<>();
        for(GriddableCreator el: saveTable){
            table.add(new SerializableGridderCreator(el));
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(savefile + ".cbman"));
            out.writeObject(table);
   //         out.putFields()
            out.close();
            out = new ObjectOutputStream(new FileOutputStream(savefile + "1.cbman" ));
            out.writeObject(UIManager.getInstance().getGrid().obtainGrid());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void export(){
        //TODO make better refactored code.
        UIManager.getInstance().getGrid().export();
    }
}
