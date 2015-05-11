package Ambience;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class Flora implements  Ambience{
    private StringProperty nome;
    private BooleanProperty uniqness;
    private ObjectProperty<Color> colore;


    public Flora(StringProperty nome, ObjectProperty<Color>  colore, BooleanProperty uniq){
        this.nome = nome;
        this.colore = colore;
        this.uniqness = uniq;

    }

    @Override
    public int OcclusionVisibility() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int VelocityPenality() {
        throw new UnsupportedOperationException();
    }

    @Override
    public StringProperty TerrainType() {
        return this.nome;
    }

    @Override
    public ObjectProperty<Color> getColor() {
        return this.colore;
    }

    @Override
    public void setColor() {
        throw new UnsupportedOperationException();
    }


    @Override
    public BooleanProperty IsUnique(){return uniqness;}

    @Override
    public String toString(){
        return TerrainType().getName() + ", " + getColor().getName() + ", " + IsUnique().get();
    }
}
