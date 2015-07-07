package Daemon;

import Ambience.Flora;
import Ambience.Obj;
import Charcacter.Fauna;
import Charcacter.NPC;
import Charcacter.PG;
import Gridder.Gridable;
import Gridder.ManageableTypes;
import javafx.beans.property.*;
import javafx.scene.paint.Color;


/**
 * Created by Lorenzo on 27/04/2015.
 * MiddleEnd Object.
 * TODO More robust check during creation.
 */
public class GriddableCreator {
    private Gridable    Ogg;
    private StringProperty nome;
    private BooleanProperty univoco;
    private ObjectProperty<Color> colore;
    private ManageableTypes  Tipo;
    private ObjectProperty<ManageableTypes> Type;

    public GriddableCreator(Object... inf){
        this.Tipo = ManageableTypes.valueOf(String.valueOf(inf[0]).toUpperCase());
        this.nome = new SimpleStringProperty((String)inf[1]);
        this.colore =  new SimpleObjectProperty<Color>((Color) inf[2]);
        this.univoco = new SimpleBooleanProperty((Boolean)inf[3]);
        this.Type = new SimpleObjectProperty<ManageableTypes>(ManageableTypes.valueOf(String.valueOf(inf[0]).toUpperCase()));
        if(this.Tipo == ManageableTypes.FLORA) {
            this.Ogg = new Flora(nome,colore,univoco);
        }
        if(this.Tipo == ManageableTypes.OBJECT) {
            this.Ogg = new Obj(nome,colore,univoco);
        }
        if(this.Tipo == ManageableTypes.FAUNA) {
            this.Ogg = new Fauna(nome,colore,univoco);
        }
        if(this.Tipo == ManageableTypes.PG) {
            this.Ogg = new PG(nome,colore,univoco);
        }
        if(this.Tipo == ManageableTypes.NPC) {
            this.Ogg = new NPC(nome,colore,univoco);
        }
    }

    public Gridable get(){
        return Ogg;
    }

    public StringProperty getName(){ return  this.nome;}

    public ObjectProperty<ManageableTypes> getType(){ return this.Type;}

    public ObjectProperty<Color> getColor(){ return this.colore;}

    public BooleanProperty getUnique(){ return this.univoco;}

    @Override
    public String toString(){
        return getName().get() +" ," + getType().get() + " ," + getColor().get() + " ," + getUnique().get();
    }

}
