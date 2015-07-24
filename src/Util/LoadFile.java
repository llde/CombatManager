package Util;

import Daemon.GriddableCreator;
import Daemon.SerializableGridderCreator;
import Gridder.Gridable;
import Resource.UIManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class LoadFile {
    public static void loadProject(String toLoad) {
        try {
            List<SerializableGridderCreator> lst = null;
            FileInputStream filein = new FileInputStream(toLoad + ".cbman");
            ObjectInputStream ios =  new ObjectInputStream(filein);
            lst = (List<SerializableGridderCreator>)ios.readObject();
            ios.close();
            filein.close();
            UIManager.getInstance().getTable().obtainTable().clear();
            for(SerializableGridderCreator gridable: lst){
                UIManager.getInstance().getTable().obtainTable().add(gridable.toGriddable());
            }
            filein = new FileInputStream(toLoad + "1.cbman");
            ios = new ObjectInputStream(filein);
            Gridable[][] griddata = (Gridable[][]) ios.readObject();
            UIManager.getInstance().getGrid().setGrid(griddata);
        } catch (IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
