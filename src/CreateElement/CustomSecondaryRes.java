package CreateElement;

import Daemon.GriddableCreator;
import Gridder.ManageableTypes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by Lorenzo on 27/04/2015.
 * Render and table model resource
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
            GriddableCreator myself = (GriddableCreator) value;
            Color colore = null;
            if (valueAt != null) {
                colore = myself.getColor();
            }
            c.setBackground(colore);
            c.setForeground(colore);
            return c;
        }
    }

    public static class TypeRender extends DefaultTableCellRenderer {
        public TypeRender() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            ManageableTypes val = null;
            if(value != null) {
                 val = ((GriddableCreator) value).getType();
            }
            Component c = super.getTableCellRendererComponent(table, val, isSelected, hasFocus, row, column);
            return c;
        }
    }
    public static class CheckBoxRender extends DefaultTableCellRenderer {
        public CheckBoxRender() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Boolean val = null;
            if(value != null) {
                 val = ((GriddableCreator) value).getUnique();
            }
            Component c = super.getTableCellRendererComponent(table, val, isSelected, hasFocus, row, column);
            return c;
        }
    }

    public static class NameRender extends DefaultTableCellRenderer {
        public NameRender() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String val = null;
            if(value != null) {
                 val = ((GriddableCreator) value).getName();
            }
            Component c = super.getTableCellRendererComponent(table, val, isSelected, hasFocus, row, column);
            return c;
        }
    }
    public static  class  SecondaryTable extends AbstractTableModel {
        private Object[][] Data = new Object[4][1];   // to make variable
        private Object[]    columnNames = {"Nome", "Tipo", "Colore", "Univoco"};

        public SecondaryTable() {
            super();
        }

        public void addRow(GriddableCreator obj){
            if(this.Data[0][0] == null){
                this.Data[0][this.Data[0].length -1] = obj;
                this.Data[1][this.Data[1].length -1] = obj;
                this.Data[2][this.Data[2].length -1] = obj;
                this.Data[3][this.Data[3].length -1] = obj;
                this.fireTableRowsInserted(0, this.getRowCount() - 1);
                return;
            }
            this.Data[0] = Arrays.copyOf(this.Data[0], this.Data[0].length +1);
            this.Data[0][this.Data[0].length -1] = obj;
            this.Data[1] = Arrays.copyOf(this.Data[1], this.Data[1].length +1);
            this.Data[1][this.Data[1].length -1] = obj;
            this.Data[2] = Arrays.copyOf(this.Data[2], this.Data[2].length +1);
            this.Data[2][this.Data[2].length -1] = obj;
            this.Data[3] = Arrays.copyOf(this.Data[3], this.Data[3].length +1);
            this.Data[3][this.Data[3].length -1] = obj;
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

