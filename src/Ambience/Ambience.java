package Ambience;

import Gridder.Gridable;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public interface Ambience extends Gridable {

    int OcclusionVisibility();

    int VelocityPenality();

    String TerrainType();



}
