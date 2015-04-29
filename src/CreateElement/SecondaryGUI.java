package CreateElement;

import Ambience.Flora;
import Daemon.GriddableCreator;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Lorenzo on 25/04/2015.
 */
public class SecondaryGUI {
    private static String[] tipi = {"PG", "NPC", "Object", "Flora", "Fauna"};
    private static GriddableCreator grids;
    private  static JTable sec;
    private static void constructGridable(){
        JFrame  builder = new JFrame("Builder");
        JPanel pan = new JPanel();
        JTextField nome = new JTextField("Name");
        JColorChooser colore = new JColorChooser();
        JCheckBox univoco = new JCheckBox("Unique?");
        JComboBox<? extends String> type = new JComboBox<String>(tipi);
        JButton OK = new JButton("OK");
        JButton Cancella = new JButton("Abort");
        OK.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Object[] ogg = new Object[4];
                ogg[0] = type.getSelectedItem();
                ogg[1] = nome.getText();
                ogg[2] = colore.getColor();
                ogg[3] = univoco.isSelected();
                grids = new GriddableCreator(ogg);
                ((CustomSecondaryRes.SecondaryTable) sec.getModel()).addRow((Flora) grids.get().getClass().cast(grids.get()));
                builder.setVisible(false);
            }
        });
        Cancella.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                builder.setVisible(false);
            }
        });
        pan.add(OK);
        pan.add(type);
        pan.add(Cancella);
        pan.add(univoco);
        pan.add(nome);
        pan.add(colore);
        builder.add(pan);
        builder.pack();
        builder.setVisible(true);

        //Construct gridable and add options.

    }

    static class PopClickListener extends MouseAdapter{
        private  void createmenu(MouseEvent e){
            JPopupMenu popup = new JPopupMenu();
            JMenuItem nuovo = new JMenuItem("New");
            JMenuItem cancella = new JMenuItem("Delete");
            nuovo.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    constructGridable();
                }
            });
            cancella.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mouseClicked(e);
                }
            });
            popup.add(nuovo);
            popup.add(cancella);
            popup.show(e.getComponent(), e.getX(), e.getY());
        }

        public void mousePressed(MouseEvent e) {
            if(e.isPopupTrigger()) createmenu(e);
        }

        public void mouseReleased(MouseEvent e) {
            if(e.isPopupTrigger()) createmenu(e);
        }

    }

   /* static  class SecondaryCheckBoxesRender extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component  x =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            return x;

        }
    }*/

    public static JTable   getSecondaryGUI(){
        sec = new JTable(new CustomSecondaryRes.SecondaryTable());
        sec.addMouseListener(new PopClickListener());
        sec.getColumn("Colore").setCellRenderer(new CustomSecondaryRes.ColorRender());
        return sec;
    }
}
