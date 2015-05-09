package CreateElement;

import Daemon.GriddableCreator;
import Gridder.ManageableTypes;
import Resource.UIManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
    private TableColumn<GriddableCreator,ManageableTypes>  ColumnType;
    @FXML
    private TableColumn<GriddableCreator, Color> ColumnColor;
    @FXML
    private TableColumn<GriddableCreator, Boolean>  ColumnUnique;


    public TableViewer() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resource/TableGUI.fxml"));
        ObservableList<GriddableCreator> k = FXCollections.observableArrayList();
        k.add(new GriddableCreator("Flora", "Foresta", Color.CHOCOLATE, true));
        try {
            loader.setController(this);
            ScrollPane grid = loader.load();
            ColumnName.setCellValueFactory(cellData -> cellData.getValue().getName());
            ColumnType.setCellValueFactory(cellData -> cellData.getValue().getType());
            ColumnColor.setCellValueFactory(cellData -> cellData.getValue().getColor());
            ColumnUnique.setCellValueFactory(cellData -> cellData.getValue().getUnique());
            ColumnColor.setCellFactory(column -> {
                return new TableCell<GriddableCreator,Color>() {

                    @Override
                    protected void updateItem(Color item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.toString());
                            setBackground(new Background(new BackgroundFill(item, CornerRadii.EMPTY, Insets.EMPTY)));
                        //To experiment    setBackground(new Background(new BackgroundFill(item, new CornerRadii(10), Insets.EMPTY)));
                            setTextFill(item);
                        }
                    }
                };
            });
            TableGen.setItems(k);
            Stage Grid = new Stage();
            Scene scena = new Scene(grid);
            Grid.setScene(scena);
            UIManager.getInstance().setTableScene(scena);
            Grid.setX(200);
            Grid.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
