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
        private Object[][] Data = new Object[config.getNumberGridRow()][config.getNumberGridColumn()];

        public ManagedGridTable(){
            super();
            for(int i = 0; i < Data.length; i++) {
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

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        public void setValueAt(Object value, int row, int col) {
            Data[row][col] = value;
            fireTableCellUpdated(row, col);
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
                javafx.scene.paint.Color col = val.getColor().getValue();
                String color = "Red: " + col.toString().substring(2, 4);
                color += " Green: " + col.toString().substring(4,6);
                color += " Blue: " + col.toString().substring(6,8);
                color += " Alpha: " + col.toString().substring(8,10) + " ";
                int red = Integer.decode("0x" + col.toString().substring(2, 4));
                int green = Integer.decode("0x" + col.toString().substring(4,6));
                int blue = Integer.decode("0x" + col.toString().substring(6,8));
                int alpha = Integer.decode("0x" + col.toString().substring(8,10));
                System.out.println(red + "  " + green + "  " + blue +"   " + alpha);
                System.out.println(color);
                colore = new Color(red,green ,blue, alpha);
            }
            c.setBackground(colore);
            c.setForeground(colore);
            return c;
        }
    }
}

