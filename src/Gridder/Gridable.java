package Gridder;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.*;

/**
 * Created by Lorenzo on 25/04/2015.
 * Interfaccia sperimentale per gli oggetti visualizzabili nella grid.
 * Ogni oggetto visualizzabile nella ManagedGrid deve implementare questa interfaccia, o una delle sue sotto-interfacce.
 */
public interface Gridable {

    ObjectProperty<Color> getColor();

  //  Icon getIcon();

    void setColor();


  //  void setIcon();


    BooleanProperty IsUnique();
}
