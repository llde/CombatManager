package Grid;

import Resource.UIManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Created by Lorenzo on 08/05/2015.
 */
public class MangedGridFX {
    @FXML
    private GridPane GridModel;


    public MangedGridFX(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resource/GridGUI.fxml"));
        try {
            loader.setController(this);
            ScrollPane grid = loader.load();
            Stage Grid = new Stage();
            Scene scena = new Scene(grid);
            UIManager.getInstance().setGridScene(scena);
            Grid.setScene(scena);
            Grid.setX(10);
            Grid.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
