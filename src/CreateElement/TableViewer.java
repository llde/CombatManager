package CreateElement;

import Daemon.GriddableCreator;
import Daemon.Holder;
import Gridder.ManageableTypes;
import Resource.UIManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Lorenzo on 08/05/2015.
 *
 * Part of the JavaFX porting
 */
public class TableViewer{
    @SuppressWarnings("unused")
    @FXML
    private TableView<GriddableCreator> TableGen;

    @SuppressWarnings("unused")
    @FXML
    private TableColumn<GriddableCreator,String> ColumnName;

    @SuppressWarnings("unused")
    @FXML
    private TableColumn<GriddableCreator,ManageableTypes>  ColumnType;

    @SuppressWarnings("unused")
    @FXML
    private TableColumn<GriddableCreator, Color> ColumnColor;

    @SuppressWarnings("unused")
    @FXML
    private TableColumn<GriddableCreator, Boolean>  ColumnUnique;


    public TableViewer() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resource/TableGUI.fxml"));
        ObservableList<GriddableCreator> k = FXCollections.observableArrayList();
        k.add(new GriddableCreator("Flora", "Foresta", Color.CHOCOLATE, true));
        k.add(new GriddableCreator("Flora", "Mare", Color.BLUE, false));
        try {
            loader.setController(this);
            ScrollPane grid = loader.load();
            Stage Grid = new Stage();
            ColumnName.setCellValueFactory(cellData -> cellData.getValue().getName());
            ColumnType.setCellValueFactory(cellData -> cellData.getValue().getType());
            ColumnColor.setCellValueFactory(cellData -> cellData.getValue().getColor());
            ColumnUnique.setCellValueFactory(cellData -> cellData.getValue().getUnique());
            ColumnColor.setCellFactory(column -> new TableCell<GriddableCreator, Color>() {

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
            });
            ColumnUnique.setCellFactory(column -> new TableCell<GriddableCreator, Boolean>() {

                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        CheckBox checkbox = new CheckBox();
                        checkbox.setSelected(item);
                        setGraphic(checkbox);
                    }
                }
            });
            TableGen.setItems(k);
            TableGen.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                System.out.println(TableGen.getSelectionModel().getSelectedItem());
                if (!TableGen.getSelectionModel().isEmpty()) {
                    @SuppressWarnings("unused")
                    Holder hold = Holder.GetHolder(TableGen.getSelectionModel().getSelectedItem().get());
                }
                event.consume();
            });
            TableGen.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
                @Override
                public void handle(ContextMenuEvent event) {
                    MenuItem nuovo = new MenuItem("New");
                    nuovo.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            BuilderScene n = new BuilderScene();
                            Grid.setScene(UIManager.getInstance().getBuilderScene());
                        }
                    });
                    MenuItem del = new MenuItem("Delete");
                    ContextMenu menu = new ContextMenu(nuovo, del);
                    menu.setAnchorX(event.getScreenX());
                    menu.setAnchorY(event.getScreenY());
                    menu.setAutoHide(true);
                    menu.setConsumeAutoHidingEvents(true);
                    menu.show(TableGen.getScene().getWindow());
                }
            });

            Scene scena = new Scene(grid);
            Grid.setScene(scena);
            UIManager.getInstance().setTableScene(scena);
            UIManager.getInstance().setTableStage(Grid);
            Grid.setX(200);
            Grid.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
