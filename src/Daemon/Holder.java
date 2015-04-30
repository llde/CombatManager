package Daemon;

import Gridder.Gridable;

/**
 * Created by Lorenzo on 30/04/2015.
 */
public class Holder {
    private Gridable objectHold;
    private static Holder  hold;

    private Holder(Gridable obj){
        this.objectHold = obj;
    }
    private Holder(){
       this(null) ;
    }

    public static Holder GetHolder(){
        if(hold != null) return hold;
        hold = new Holder();
        return hold;
    }

    public static Holder GetHolder(Gridable gridobj){
        if(hold != null){
            hold.setHolder(gridobj);
            return hold;
        }
        hold = new Holder(gridobj);
        return hold;
    }
    private void setHolder(Gridable gridobj){
        this.objectHold = gridobj;
    }
    public Gridable getGridable(){
        return this.objectHold;
    }
}
