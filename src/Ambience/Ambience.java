package Ambience;

import Gridder.Gridable;
import javafx.beans.property.StringProperty;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public interface Ambience extends Gridable {

    int OcclusionVisibility();

    int VelocityPenality();

    String TerrainType();



}
