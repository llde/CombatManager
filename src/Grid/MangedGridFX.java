package Grid;

import Daemon.GriddableCreator;
import Daemon.Holder;
import Gridder.Gridable;
import Resource.UIManager;
import Util.ConfigurationFile;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lorenzo on 08/05/2015.
 * Managed Grid rework for JavaFX. Use TableView instead of a JTable.
 */
public class MangedGridFX {
    @SuppressWarnings("unused")
    @FXML
    private TableView<ObservableList<Gridable>> GridModel;

    @SuppressWarnings("unchecked")
    public MangedGridFX(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resource/GridGUI.fxml"));
        Gridable defaulting = new GriddableCreator("Flora", "foresta", Color.GREEN, false).get();
        ArrayList<TableColumn<ObservableList<Gridable>,?>> co = new ArrayList<>(10);
        ArrayList<Gridable> obj = new ArrayList<>(10);
        for(int h = 0; h < ConfigurationFile.GetConfig().getNumberGridRow(); h++){
            obj.add(defaulting);
        }
        for(int v = 0; v < ConfigurationFile.GetConfig().getNumberGridColumn(); v++) {
            co.add(new TableColumn<>());
        }
        ObservableList<TableColumn<ObservableList<Gridable>,?>> toColumn = FXCollections.observableArrayList(co);
        ObservableList<ObservableList<Gridable>>  items  = FXCollections.observableArrayList();
        for(int o = 0; o < ConfigurationFile.GetConfig().getNumberGridRow(); o++){
            items.add(FXCollections.observableArrayList(obj));
        }
        try {
            loader.setController(this);
            ScrollPane grid = loader.load();
            GridModel.getColumns().addAll(toColumn);
            GridModel.setItems(items);
            GridModel.setFixedCellSize(ConfigurationFile.GetConfig().getyLenghtBlock());
            GridModel.setTableMenuButtonVisible(false);
            GridModel.setBorder(Border.EMPTY);
            for(int x = 0; x < GridModel.getColumns().size(); x++) {
                final int t = x;
                GridModel.getColumns().get(t).setMaxWidth(ConfigurationFile.GetConfig().getxLenghtBlock());
                GridModel.getColumns().get(t).setMinWidth(ConfigurationFile.GetConfig().getxLenghtBlock());
                GridModel.getColumns().get(t).setPrefWidth(ConfigurationFile.GetConfig().getxLenghtBlock());
                GridModel.getColumns().get(t).setResizable(false);
                //UGLY workaround to make act the tableview as a Swing JTable, as cellBased and not RowBased
                ((TableColumn<ObservableList<Gridable>, Gridable>) (GridModel.getColumns().get(t))).setCellValueFactory(cellDataFeatures -> {
                    ObservableList<Gridable> values = cellDataFeatures.getValue();
                    if (t >= values.size()) {
                        //Implements ObservableValue interface for my Gridable Objects without touch the Gridable Interface..
                        return new ObservableValue<Gridable>() {
                            @Override
                            public void addListener(ChangeListener<? super Gridable> listener) {

                            }

                            @Override
                            public void removeListener(ChangeListener<? super Gridable> listener) {

                            }

                            @Override
                            public Gridable getValue() {
                                return new GriddableCreator("Flora", "For", Color.ALICEBLUE, false).get();
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
                        cell.setBorder(Border.EMPTY);   //Hide Borders beetween columns
                        cell.setOnMouseClicked(event -> {
                            if(!GridModel.getSelectionModel().getSelectedItem().get(t).IsUnique().get()) {
                                System.out.print("Control unique");
                            }
                            GridModel.getSelectionModel().getSelectedItem().set(t, Holder.GetHolder().getGridable());
                            cell.getTableColumn().setVisible(false); //Workaround to force update of the TableView.
                            cell.getTableColumn().setVisible(true);  //sometimes I miss Swing. :(
                        });
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
    public ObservableList<ObservableList<Gridable>>  obtainGrid(){
        return null;
    }
}
