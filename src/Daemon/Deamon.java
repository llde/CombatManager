package Daemon;

import javafx.scene.paint.*;

import java.awt.*;
import java.awt.Color;

/**
 * Created by Lorenzo on 22/04/2015.
 */
public class Deamon {
    public static Color tranformColor(javafx.scene.paint.Color col){
        int red = Integer.decode("0x" + col.toString().substring(2, 4));
        int green = Integer.decode("0x" + col.toString().substring(4,6));
        int blue = Integer.decode("0x" + col.toString().substring(6,8));
        int alpha = Integer.decode("0x" + col.toString().substring(8,10));
        return new Color(red,green ,blue, alpha);
    }
}
