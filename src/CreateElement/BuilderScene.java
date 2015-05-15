package CreateElement;

import Daemon.GriddableCreator;
import Gridder.ManageableTypes;
import Resource.UIManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Lorenzo on 08/05/2015.
 */
public class BuilderScene  {
    @SuppressWarnings("unused")
    @FXML
    private CheckBox UniqueCombox;

    @SuppressWarnings("unused")
    @FXML
    private TextField NameField;

    @SuppressWarnings("unused")
    @FXML
    private ColorPicker ColorBox;

    @SuppressWarnings("unused")
    @FXML
    private ComboBox<ManageableTypes>    TypeBox;

    @SuppressWarnings("unused")
    @FXML
    private Button OK;

    @SuppressWarnings("unused")
    @FXML
    private Button Abort;

    public BuilderScene(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Resource/BuilderGui.fxml"));
        loader.setController(this);
        try{
           AnchorPane loaded = loader.load();
            Scene scen = new Scene(loaded);
            UIManager.getInstance().setBuilderScene(scen);
            TypeBox.getItems().addAll(ManageableTypes.values());
            Abort.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    UIManager.getInstance().getTableStage().setScene(UIManager.getInstance().getTableScene());
                }
            });
            OK.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    GriddableCreator x = new GriddableCreator(TypeBox.getSelectionModel().getSelectedItem(), NameField.getText(), ColorBox.getValue(), UniqueCombox.isSelected());
                    System.out.println(x.toString());
                    UIManager.getInstance().getTableStage().setScene(UIManager.getInstance().getTableScene());
                }
            });
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}