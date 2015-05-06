/**
 * Created by Lorenzo on 22/04/2015.
 * Alpha version of D&D position for play by forum adventures and combat.
 * Mine first Java GUI program.
 */
import CreateElement.MainGUI;
import Util.ConfigurationFile;

import javax.swing.*;


public class Main {

//TODO port to JavaFX
    private static void init(){
        SwingUtilities.invokeLater(new MainGUI());
    }



    public static void main(String[] args) {
        ConfigurationFile config = ConfigurationFile.GetConfig();
        config.save();
        init();
    }
}
