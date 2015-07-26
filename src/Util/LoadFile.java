package Util;

import Daemon.GriddableCreator;
import Daemon.SerializableGridderCreator;
import Gridder.Gridable;
import Resource.UIManager;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class LoadFile {
    @SuppressWarnings("unchecked")
    public static void loadProject() {
        FileChooser choose = new FileChooser();
        choose.setTitle("Load the project. The associated TableGEN is automatically loaded in the same position");
        choose.setInitialDirectory(new File("./"));
        File file = choose.showOpenDialog(UIManager.getInstance().getTableStage());
        try {
            List<SerializableGridderCreator> lst = null;
            FileInputStream filein = new FileInputStream(file.getAbsolutePath() + ".cbman");
            ObjectInputStream ios =  new ObjectInputStream(filein);
            lst = (List<SerializableGridderCreator>)ios.readObject();
            ios.close();
            filein.close();
            UIManager.getInstance().getTable().obtainTable().clear();
            for(SerializableGridderCreator gridable: lst){
                UIManager.getInstance().getTable().obtainTable().add(gridable.toGriddable());
            }
            filein = new FileInputStream(file.getAbsolutePath() + "1.cbman");
            ios = new ObjectInputStream(filein);
            Gridable[][] griddata = (Gridable[][]) ios.readObject();
            UIManager.getInstance().getGrid().setGrid(griddata);
        } catch (IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
