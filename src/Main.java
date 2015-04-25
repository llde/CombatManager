/**
 * Created by Lorenzo on 22/04/2015.
 * Alpha version of D&D position for play by forum adventures and combat.
 * Mine first GUI program.
 */
import CreateElement.MainGUI;

import javax.swing.*;


public class Main {


    private static void init(){
        SwingUtilities.invokeLater(new MainGUI());
    }



    public static void main(String[] args) {
        init();
    }
}
