package Grid;

import Daemon.GriddableCreator;
import Daemon.Holder;
import Gridder.Gridable;
import Resource.UIManager;
import Util.ConfigurationFile;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lorenzo on 08/05/2015.
 * Managed Grid rework for JavaFX. Use TableView instead of a JTable.
 * Using a fucked SwingPanel
 */
public class MangedGridFX {
    @FXML
    private SwingNode SwingFX;

    public MangedGridFX() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resource/GridGUI.fxml"));
        loader.setController(this);
        try {
            ScrollPane scp = loader.load();
            JTable gridtable = new JTable(new ManagedGridResource.ManagedGridTable());
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
            SwingFX.resize(1000,1000);
            SwingFX.autosize();
            SwingFX.setVisible(true);
            SwingFX.setVisible(true);
            SwingFX.setOpacity(1.0);
            Gridable defaulting = new GriddableCreator("Flora", "foresta", Color.GREEN, false).get();
            Scene Grid = new Scene(scp);
            Stage Sta = new Stage();
            Sta.setScene(Grid);
            Sta.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ObservableList<ObservableList<Gridable>>  obtainGrid(){
        return null;
    }
}
