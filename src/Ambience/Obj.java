package Ambience;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class Obj implements Ambience{
    private  String nome;
    private boolean block;
    private boolean uniqness;
    private Color colore;



    public Obj(String nome, Color  colore, boolean uniq){
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
    public Icon getIcon() {
        return null;
    }

    @Override
    public void setColor() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setIcon() {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean IsUnique(){return uniqness;}

}
