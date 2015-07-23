package Daemon;

import Gridder.ManageableTypes;
import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by Lorenzo on 23/07/2015.
 */
public class SerializableGridderCreator  implements Serializable {
    ManageableTypes Tipo;
    String nome;
    double[] colore = new double[4];
    boolean unico;



    public SerializableGridderCreator(GriddableCreator creator){
        Tipo = creator.getType().get();
        nome = creator.getName().get();
        colore[0] = creator.getColor().get().getRed();
        colore[1] = creator.getColor().get().getGreen();
        colore[2] = creator.getColor().get().getBlue();
        colore[3] = creator.getColor().get().getOpacity();
        unico = creator.getUnique().get();
    }
}