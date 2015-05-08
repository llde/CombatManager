package CreateElement;

import Daemon.GriddableCreator;
import Gridder.Gridable;
import Gridder.ManageableTypes;
import Resource.UIManager;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

/**
 * Created by Lorenzo on 08/05/2015.
 *
 * Part of the JavaFX porting
 */
public class TableViewer{
    @FXML
    private TableView TableGen;
    @FXML
    private TableColumn<GriddableCreator,String> ColumnName;
    @FXML
    private TableColumn<GriddableCreator,String>  ColumnType;
    @FXML
    private TableColumn<GriddableCreator, Color> ColumnColor;
    @FXML
    private TableColumn<GriddableCreator, Boolean>  ColumnUnique;


    public TableViewer() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resource/TableGUI.fxml"));
        try {
            ScrollPane grid = loader.load();
            Stage Grid = new Stage();
            Scene scena = new Scene(grid);
            Grid.setScene(scena);
            UIManager.getInstance().setTableScene(scena);
            Grid.setX(800);
            Grid.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.setController(this);
    }
}
