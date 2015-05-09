package CreateElement;

import Daemon.GriddableCreator;
import Resource.UIManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Lorenzo on 08/05/2015.
 *
 * Part of the JavaFX porting
 */
public class TableViewer{
    @FXML
    private TableView<GriddableCreator> TableGen;
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
        ObservableList<GriddableCreator> k = FXCollections.observableArrayList();
        k.add(new GriddableCreator("Flora", "Foresta", Color.CHOCOLATE, true));
        try {
            ScrollPane grid = loader.load();
            ColumnName.setCellValueFactory(cellData -> cellData.getValue().getName());
            Stage Grid = new Stage();
            Scene scena = new Scene(grid);
            Grid.setScene(scena);
            UIManager.getInstance().setTableScene(scena);
            Grid.setX(200);
            Grid.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.setController(this);
    }
}
