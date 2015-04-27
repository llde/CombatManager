package CreateElement;

import Gridder.Gridable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Lorenzo on 25/04/2015.
 */
public class SecondaryGUI {
    private static void constructGridable(){
        JFrame  builder = new JFrame("Builder");
        JPanel pan = new JPanel();
        builder.add(pan);
        builder.setSize(60,60);
        builder.repaint();
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
    static class ColorRender extends DefaultTableCellRenderer{
        public ColorRender(){
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected,boolean hasFocus,int row,int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Object valueAt = table.getModel().getValueAt(row, column);
            Gridable val = (Gridable) value;
            Color colore = null;
            if (valueAt != null) {
                colore = val.getColor();
            }
            c.setBackground(colore);
            c.setForeground(colore);
            return c;
        }
    }

   /* static  class SecondaryCheckBoxesRender extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component  x =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            return x;

        }
    }*/
    static class  SecondaryTable extends AbstractTableModel {
        private Object[][] Data = new Object[4][1];   // to make variable
        private Object[]    columnNames = {"Nome", "Tipo", "Colore", "Univoco"};

        @Override
        public int getRowCount() {
            return Data[0].length;
        }

        @Override
        public int getColumnCount() {
            return Data.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return Data[columnIndex][rowIndex];
        }

        public SecondaryTable() {
            super();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column].toString();
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return Data[columnIndex].getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        public void setValueAt(Object value, int row, int col) {
            Data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
    public static JTable   getSecondaryGUI(){
        JTable sec = new JTable(new SecondaryTable());
        sec.addMouseListener(new PopClickListener());
        sec.getColumn("Colore").setCellRenderer(new ColorRender());
        return sec;
    }
}
