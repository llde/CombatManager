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
 */
public class GriddableCreator {
    private Gridable    Ogg;
    private Flora FloraOgg;
    private ManageableTypes  Tipo;

    public GriddableCreator(Object... inf){
        this.Tipo = ManageableTypes.valueOf(((String) inf[0]).toUpperCase());
        String nome = (String) inf[1];
        Color colore = (Color) inf[2];
        boolean univoco = (Boolean) inf[3];
        if(this.Tipo == ManageableTypes.FLORA) {
            this.FloraOgg = new Flora(nome,colore);
            this.Ogg = this.FloraOgg;
        }
        System.out.print(nome);
    }
    public Gridable get(){
        return Ogg;
    }
}
