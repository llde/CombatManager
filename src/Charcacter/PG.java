package Charcacter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class PG implements Character{
    private  String nome;
    private boolean block;
    private boolean uniqness;
    private Color colore;



    public PG(String nome, Color  colore, boolean uniq){
        this.nome = nome;
        this.colore = colore;
        this.uniqness = uniq;

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
    }

    @Override
    public void setIcon() {

    }

    @Override
    public boolean IsUnique(){return uniqness;}

}
