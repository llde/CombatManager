package Charcacter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class NPC implements Character{
    private  String nome;
    private boolean block;
    private Color colore;



    public NPC(String nome, Color  colore){
        this.nome = nome;
        this.colore = colore;
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
}

