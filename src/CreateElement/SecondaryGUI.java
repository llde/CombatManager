package CreateElement;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Lorenzo on 25/04/2015.
 */
public class SecondaryGUI {
    private static void constructGridable(){
        JFrame  builder = new JFrame("Builder");
        JPanel pan = new JPanel();
        JTextField nome = new JTextField("Name");
        JColorChooser colore = new JColorChooser();
        JCheckBox univoco = new JCheckBox("Unique?");
        JButton OK = new JButton("OK");
        JButton Cancella = new JButton("Abort");
        pan.add(OK);
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
        JTable sec = new JTable(new CustomSecondaryRes.SecondaryTable());
        sec.addMouseListener(new PopClickListener());
        sec.getColumn("Colore").setCellRenderer(new CustomSecondaryRes.ColorRender());
        return sec;
    }
}
