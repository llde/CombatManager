package Gridder;


import java.awt.*;
import java.io.Serializable;

/**
 * Created by Lorenzo on 25/04/2015.
 * Interfaccia sperimentale per gli oggetti visualizzabili nella grid.
 * Ogni oggetto visualizzabile nella ManagedGrid deve implementare questa interfaccia, o una delle sue sotto-interfacce.
 */
public interface Gridable extends Serializable{
    Color getColor();

  //  Icon getIcon();

    void setColor();


  //  void setIcon();


    Boolean IsUnique();
}
