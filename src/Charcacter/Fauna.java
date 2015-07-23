package Charcacter;

import java.awt.*;
import java.io.Serializable;


/**
 * Created by Lorenzo on 22/04/2015.
 */
public class Fauna implements Character,Serializable{
    private String nome;
    private Boolean block;
    private Boolean uniqness;
    private Color colore;



    public Fauna(String nome, Color  colore, Boolean uniq){
        this.nome = nome;
        this.colore = colore;
        this.uniqness = uniq;
    }

    @Override
    public Color getColor() {
        return this.colore;
    }


    @Override
    public void setColor() {
    }

    @Override
    public Boolean IsUnique(){return uniqness;}

}
