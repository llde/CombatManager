package Charcacter;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;


/**
 * Created by Lorenzo on 22/04/2015.
 */
public class PG implements Character{
    private StringProperty nome;
    private BooleanProperty block;
    private BooleanProperty uniqness;
    private ObjectProperty<Color> colore;



    public PG(StringProperty nome, ObjectProperty<Color>  colore, BooleanProperty uniq){
        this.nome = nome;
        this.colore = colore;
        this.uniqness = uniq;

    }
    @Override
    public ObjectProperty<Color> getColor() {
        return this.colore;
    }

    @Override
    public void setColor() {
    }

    @Override
    public BooleanProperty IsUnique(){return uniqness;}

}
