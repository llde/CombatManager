package Charcacter;


import java.awt.*;
import java.io.Serializable;


/**
 * Created by Lorenzo on 22/04/2015.
 */
public class PG implements Character,Serializable{
    private static final long serialVersionUID = 8529685098267757695L;

    private String nome;
    private Boolean block;
    private Boolean uniqness;
    private Color colore;



    public PG(String nome, Color  colore, Boolean uniq){
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
