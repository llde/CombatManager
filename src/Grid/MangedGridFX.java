package Grid;

import Daemon.Holder;
import Gridder.Gridable;
import Resource.UIManager;
import Util.ConfigurationFile;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by Lorenzo on 08/05/2015.
 * Managed Grid rework for JavaFX.
 * Using a fucked SwingPanel
 * TODO: operations on the swing component should be done on Swing thread or on the Event dispatch thread
 */
public class MangedGridFX {
    @FXML
    private SwingNode SwingFX;

    private JTable gridtable;

    public MangedGridFX() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resource/GridGUI.fxml"));
        loader.setController(this);
        try {
            ScrollPane scp = loader.load();
            gridtable = new JTable(new ManagedGridResource.ManagedGridTable());
            gridtable.setDefaultRenderer(Object.class , new ManagedGridResource.GridCellRender());
            for (int index = 0; index < gridtable.getColumnCount(); index++) {
                TableColumn colonna = gridtable.getColumnModel().getColumn(index);
                //         coloqnna.setHeaderValue(null);  //Swing di merda!
                colonna.setResizable(false);
                colonna.setPreferredWidth(ConfigurationFile.GetConfig().getxLenghtBlock());
            }
            gridtable.setRowHeight(ConfigurationFile.GetConfig().getyLenghtBlock());
            gridtable.setTableHeader(null);
            gridtable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Gridable gridObj = Holder.GetHolder().getGridable();
                    int row = gridtable.rowAtPoint(e.getPoint());
                    int col = gridtable.columnAtPoint(e.getPoint());
                    gridtable.setValueAt(gridObj,row,col);
                }
            });
            SwingFX.setContent(gridtable);
            SwingFX.autosize();
            SwingFX.setVisible(true);
            SwingFX.setOpacity(1.0);
            Scene Grid = new Scene(scp);
            Stage Sta = new Stage();
            Sta.setScene(Grid);
            Sta.show();
            UIManager.getInstance().setGridScene(Grid);
       }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Gridable[][] obtainGrid(){
        return ((ManagedGridResource.ManagedGridTable)gridtable.getModel()).getData();
    }

    public void setGrid(Gridable[][] gridd ) {
        ((ManagedGridResource.ManagedGridTable) gridtable.getModel()).setData(gridd);
        gridtable.repaint();
    }

    public SwingNode exportSwingPane() {
        return SwingFX;
    }
}