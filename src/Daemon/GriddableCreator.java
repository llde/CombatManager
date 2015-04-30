package Daemon;

import Ambience.Flora;
import Gridder.Gridable;
import Gridder.ManageableTypes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lorenzo on 27/04/2015.
 * MiddleEnd Object.
 */
public class GriddableCreator {
    private Gridable    Ogg;
    private Flora FloraOgg;
    private String nome;
    private boolean univoco;
    private Color colore;
    private ManageableTypes  Tipo;

    public GriddableCreator(Object... inf){
        this.Tipo = ManageableTypes.valueOf(((String) inf[0]).toUpperCase());
        this.nome = (String) inf[1];
        this.colore = (Color) inf[2];
        this.univoco = (Boolean) inf[3];
        if(this.Tipo == ManageableTypes.FLORA) {
            this.FloraOgg = new Flora(nome,colore);
            this.Ogg = this.FloraOgg;
        }
    }

    public Gridable get(){
        return Ogg;
    }

    public String getName(){ return  this.nome;}

    public ManageableTypes getType(){ return this.Tipo;}

    public Color getColor(){ return this.colore;}

    public Boolean getUnique(){ return this.univoco;}

}
