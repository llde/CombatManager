package CreateElement;

import Gridder.Gridable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by Lorenzo on 25/04/2015.
 */
public class SecondaryGUI {
    static class GridCellRender extends DefaultTableCellRenderer implements TableCellRenderer {
        public GridCellRender(){
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
    static class  SecondaryTable extends AbstractTableModel {
        private Object[][] Data = new Object[10][10];   // to make variable

        @Override
        public int getRowCount() {
            return Data.length;
        }

        @Override
        public int getColumnCount() {
            return Data[0].length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return Data[rowIndex][columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return super.getColumnClass(columnIndex);
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
        return sec;
    }
}
