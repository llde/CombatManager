package Grid;

import Util.ConfigurationFile;

import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 * Created by Lorenzo on 22/04/2015.
    Estensione della classe JTable per una grid multicomponente
 */
public class ManagedGrid extends JComponent  {
    private  static JTable table;
    public static JTable GetTableSingleton(boolean newi) {
        ConfigurationFile config = ConfigurationFile.GetConfig();
        if(newi) {
            table = new JTable(new Renders.ManagedGridTable(), null, null);
            Renders.GridCellRender gridrender = new Renders.GridCellRender();
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  //Disable native autoresize
            //      table.setColumnModel(null);
            for (int index = 0; index < table.getColumnCount(); index++) {
                TableColumn colonna = table.getColumnModel().getColumn(index);
                //         coloqnna.setHeaderValue(null);  //Swing di merda!
                colonna.setResizable(false);
                //       colonna.setMinWidth(40);
                //       colonna.setMaxWidth(40);
                colonna.setPreferredWidth(config.getxLenghtBlock());
            }
            table.setRowHeight(config.getyLenghtBlock());
            table.setRowMargin(0);
            table.setTableHeader(null);
            gridrender.setOpaque(true);
            table.setDefaultRenderer(Object.class, gridrender);
            table.repaint();
        }
        return table;
    }
}
