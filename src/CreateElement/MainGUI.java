package CreateElement;

import Daemon.Holder;
import Grid.ManagedGrid;
import Gridder.Gridable;
import Util.ConfigurationFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Lorenzo on 25/04/2015.
 */
public class MainGUI  implements Runnable {
    public void  run(){
        ConfigurationFile config = ConfigurationFile.GetConfig();
        JFrame titolo = new JFrame("D&D combat manager");
        JFrame griglia = new JFrame("Griglia");
        JFrame selezione = new JFrame("Selezione elemento");
        titolo.setSize(300, 100);
        titolo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        titolo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(titolo, "Are you sure ?") == JOptionPane.OK_OPTION) {
                    titolo.dispose();
                    ConfigurationFile.GetConfig().save();
                    System.exit(0);
                }
            }
        });
        JToolBar principale = new JToolBar();
        principale.add(new JButton("Load"));
        principale.add(new JButton("Save"));
        principale.add(new JButton("Export"));
        principale.add(new JButton("New"));
        JTable selectionelement = SecondaryGUI.getSecondaryGUI(true);
        JTable gridtable = ManagedGrid.GetTableSingleton(true);
        gridtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Gridable gridObj = Holder.GetHolder().getGridable();
                int row = gridtable.rowAtPoint(e.getPoint());
                int col = gridtable.columnAtPoint(e.getPoint());
                gridtable.setValueAt(gridObj,row,col);
            }

        });
        JScrollPane pan = new JScrollPane(gridtable);
        JScrollPane selel = new JScrollPane(selectionelement);
        titolo.add(principale);
        selezione.getContentPane().add(selel);
        griglia.getContentPane().add(pan, BorderLayout.CENTER);
    //    griglia.setSize(512, 512);
     //   selezione.setSize(300,300);
        griglia.pack();
        selezione.pack();
        griglia.setVisible(true);
        selezione.setVisible(true);
        titolo.setVisible(true);
    }

}

