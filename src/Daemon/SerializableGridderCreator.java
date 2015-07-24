package Daemon;

import Gridder.ManageableTypes;
import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by Lorenzo on 23/07/2015.
 */
public class SerializableGridderCreator  implements Serializable {
    private static final long serialVersionUID = 8529685098267757690L;
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

    public GriddableCreator toGriddable(){
        return new GriddableCreator(Tipo, nome, new Color(colore[0], colore[1], colore[2], colore[3]), unico);
    }
}