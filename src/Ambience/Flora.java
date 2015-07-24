package Ambience;


import java.awt.*;
import java.io.Serializable;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class Flora implements  Ambience, Serializable{
    private static final long serialVersionUID = 8529685098267757691L;
    private String nome;
    private Boolean uniqness;
    private Color colore;


    public Flora(String nome, Color colore, Boolean uniq){
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
    public String TerrainType() {
        return this.nome;
    }

    @Override
    public Color getColor() {
        return this.colore;
    }

    @Override
    public void setColor() {
        throw new UnsupportedOperationException();
    }


    @Override
    public Boolean IsUnique(){return uniqness;}

    @Override
    public String toString(){
        return TerrainType() + ", " + getColor() + ", " + IsUnique();
    }
}
