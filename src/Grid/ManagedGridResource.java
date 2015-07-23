package Grid;


import Gridder.Gridable;
import Util.ConfigurationFile;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.Color;
import java.util.Arrays;

/**
 * Created by lorenzo on 06/07/15.
 */
public class ManagedGridResource {
    public static class  ManagedGridTable extends AbstractTableModel {
        private ConfigurationFile config = ConfigurationFile.GetConfig();
        private Gridable[][] Data = new Gridable[config.getNumberGridRow()][config.getNumberGridColumn()];

        public ManagedGridTable(){
            super();
            for(int i = 0; i < Data.length; i++) {
                //TODO controllo in caso di default non definito.
                Arrays.fill(Data[i], config.getGridableDefault());
            }
        }

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
        public boolean isCellEditable(int row, int col) {
            return false;
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            Data[row][col] = (Gridable)value;
            fireTableCellUpdated(row, col);
        }

        public Gridable[][] getData() {
            return Data;
        }

        public void setData(Gridable[][] data) {
            Data = data;
        }
    }
    public static class GridCellRender extends DefaultTableCellRenderer implements TableCellRenderer {
        public GridCellRender(){
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected,boolean hasFocus,int row,int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Object valueAt = table.getModel().getValueAt(row, column);
            Gridable val = (Gridable) value;
            Color colore = null;
            Icon icona;
            if (valueAt != null) {
                colore = val.getColor();
            }
            c.setBackground(colore);
            c.setForeground(colore);
            return c;
        }
    }
}

