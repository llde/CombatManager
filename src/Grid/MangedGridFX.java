package Grid;

import Daemon.GriddableCreator;
import Gridder.Gridable;
import Resource.UIManager;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lorenzo on 08/05/2015.
 * Managed Grid rework for JavaFX. Use TableView instead of a JTable.
 */
public class MangedGridFX {
    @FXML
    private TableView<ObservableList<Gridable>> GridModel;

    @SuppressWarnings("unchecked")
    public MangedGridFX(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resource/GridGUI.fxml"));
        List<Gridable> f = new ArrayList<>();
        f.add(new GriddableCreator("Flora", "Foresta", Color.CHOCOLATE, true).get());
        f.add(new GriddableCreator("Flora", "Mare", Color.BLUE, true).get());
        List<Gridable> f1 = new ArrayList<>();
        f1.add(new GriddableCreator("Flora", "Foresta", Color.GREEN, true).get());
        f1.add(new GriddableCreator("Flora", "Mare", Color.MAGENTA, false).get());
        ObservableList<ObservableList<Gridable>>  k = FXCollections.observableArrayList();
        ObservableList<Gridable> i = FXCollections.observableList(f);
        ObservableList<Gridable> i1 = FXCollections.observableList(f1);
        k.add(i);
        k.add(i1);
        try {
            loader.setController(this);
            ScrollPane grid = loader.load();
            GridModel.setItems(k);
            for(int x = 0; x < GridModel.getColumns().size(); x++) {
                final int t = x;
                ((TableColumn<ObservableList<Gridable>, Gridable>) (GridModel.getColumns().get(t))).setCellValueFactory(cellDataFeatures -> {
                    ObservableList<Gridable> values = cellDataFeatures.getValue();
                    if (t >= values.size()) {
                        return new ObservableValue<Gridable>() {
                            @Override
                            public void addListener(ChangeListener<? super Gridable> listener) {

                            }

                            @Override
                            public void removeListener(ChangeListener<? super Gridable> listener) {

                            }

                            @Override
                            public Gridable getValue() {
                                return new GriddableCreator("FLora", "For", Color.ALICEBLUE, false).get();
                            }

                            @Override
                            public void addListener(InvalidationListener listener) {

                            }

                            @Override
                            public void removeListener(InvalidationListener listener) {

                            }
                        };
                    } else {
                        return new ObservableValue<Gridable>() {
                            @Override
                            public void addListener(ChangeListener<? super Gridable> listener) {

                            }

                            @Override
                            public void removeListener(ChangeListener<? super Gridable> listener) {

                            }

                            @Override
                            public Gridable getValue() {
                                return values.get(t);
                            }

                            @Override
                            public void addListener(InvalidationListener listener) {

                            }

                            @Override
                            public void removeListener(InvalidationListener listener) {

                            }
                        };
                    }
                });
                ((TableColumn<ObservableList<Gridable>, Gridable>) (GridModel.getColumns().get(t))).setCellFactory(new Callback<TableColumn<ObservableList<Gridable>, Gridable>, TableCell<ObservableList<Gridable>, Gridable>>() {
                    @Override
                    public TableCell<ObservableList<Gridable>, Gridable> call(TableColumn<ObservableList<Gridable>, Gridable> param) {
                        TableCell<ObservableList<Gridable>, Gridable> cell = new TableCell<ObservableList<Gridable>, Gridable>() {
                            @Override
                            protected void updateItem(Gridable item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.toString());
                                    setBackground(new Background(new BackgroundFill(item.getColor().get(), CornerRadii.EMPTY, Insets.EMPTY)));
                                    //To experiment    setBackground(new Background(new BackgroundFill(item, new CornerRadii(10), Insets.EMPTY)));
                                    setTextFill(item.getColor().get());
                                }
                            }
                        };
                        cell.setOnMouseClicked(event -> System.out.println(GridModel.getSelectionModel().getSelectedItem().get(t)));
                        return cell;
                    }
                });
            }
            Stage Grid = new Stage();
            Scene scena = new Scene(grid);
            UIManager.getInstance().setGridScene(scena);
            Grid.setScene(scena);
            Grid.setX(10);
            Grid.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
