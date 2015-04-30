package Grid;

import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 * Created by Lorenzo on 22/04/2015.
    Estensione della classe JTable per una grid multicomponente
 */
public class ManagedGrid extends JComponent  {
    public static JTable GetTableSingleton() {
        JTable table = new JTable(new Renders.ManagedGridTable(),null,null);
        Renders.GridCellRender gridrender  = new Renders.GridCellRender();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  //Disable native autoresize
  //      table.setColumnModel(null);
        for(int index = 0; index < table.getColumnCount(); index++){
            TableColumn colonna = table.getColumnModel().getColumn(index);
   //         colonna.setHeaderValue(null);  //Swing di merda!
            colonna.setResizable(false);
     //       colonna.setMinWidth(40);
     //       colonna.setMaxWidth(40);
            colonna.setPreferredWidth(40);
        }
        table.setRowHeight(40);
        table.setRowMargin(0);
        table.setTableHeader(null);
        gridrender.setOpaque(true);
        table.setDefaultRenderer(Object.class, gridrender);
        table.repaint();
        return table;
    }
}
