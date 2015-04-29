package CreateElement;

import Ambience.Ambience;
import Daemon.GriddableCreator;
import Gridder.Gridable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by Lorenzo on 27/04/2015.
 */

public  class CustomSecondaryRes {
    public static class ColorRender extends DefaultTableCellRenderer {
        public ColorRender() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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
    public static  class  SecondaryTable extends AbstractTableModel {
        private Object[][] Data = new Object[4][1];   // to make variable
        private Object[]    columnNames = {"Nome", "Tipo", "Colore", "Univoco"};

        public SecondaryTable() {
            super();
        }

        public void addRow(Ambience obj){
            this.Data[0] = Arrays.copyOf(this.Data[0], this.Data[0].length +1);
            this.Data[0][this.Data[0].length -1] = obj.TerrainType();
            this.Data[1] = Arrays.copyOf(this.Data[1], this.Data[1].length +1);
            this.Data[1][this.Data[1].length -1] = obj.TerrainType();
            this.Data[2] = Arrays.copyOf(this.Data[2], this.Data[2].length +1);
            this.Data[2][this.Data[2].length -1] = obj;
            this.Data[3] = Arrays.copyOf(this.Data[3], this.Data[3].length +1);
            this.Data[3][this.Data[3].length -1] = obj.TerrainType();

            this.fireTableRowsInserted(0, this.getRowCount() - 1);
        }
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
            Data[col][row] = value;
            fireTableCellUpdated(col, row);
        }
    }


}

