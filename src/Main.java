/**
 * Created by Lorenzo on 22/04/2015.
 * Alpha version of D&D position for play by forum adventures and combat.
 * Mine first Java GUI program.
 */

import CreateElement.TableViewer;
import Grid.MangedGridFX;
import Resource.UIManager;
import Util.ConfigurationFile;
import Util.ExportGrid;
import Util.LoadFile;
import Util.SaveFile;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Optional;


public class Main extends Application {
//This fields are assigned by the compiler with the FXML notation
    @FXML
    private Button  NEW;
    @FXML
    private Button LOAD;
    @FXML
    private Button SAVE;
    @FXML
    private Button EXP;

    private static void iniz(String[] args){
        launch(args);
    }


    public static void main(String[] args) {
      //  ConfigurationFile.load("CombatManager.ini");
        ConfigurationFile config = ConfigurationFile.GetConfig();
        iniz(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(event -> {
            Alert al = new Alert(Alert.AlertType.CONFIRMATION);
            al.setTitle("Confirm exiting");
            al.setContentText("Are you sure to exit?");
            Optional<ButtonType>  but = al.showAndWait();
            if(but.get() == null) event.consume();
            if(but.get() == ButtonType.CANCEL) event.consume();
            if(but.get() == ButtonType.OK) Platform.exit();
        });
        UIManager UIMAN = UIManager.getInstance();
        UIMAN.setMainScene(initRes());
        MangedGridFX Grid = new MangedGridFX();
        TableViewer view = new TableViewer();
        primaryStage.setScene(UIMAN.getMainScene());
        UIMAN.setTable(view);
        UIMAN.setGrid(Grid);
        UIMAN.setMainStage(primaryStage);
        UIMAN.getMainStage().show();
    }

    public Scene initRes(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Resource/MainGUI.fxml"));
        loader.setController(this);
        try {
            ButtonBar ancora = loader.load();
            this.NEW.setOnAction(event ->{
                UIManager man = UIManager.getInstance();
                man.getTableStage().close();
                man.getGridStage().close();
                man.setGrid(new MangedGridFX());
                man.setTable(new TableViewer());
            });
            this.SAVE.setOnAction(event -> SaveFile.SaveProject());
            this.LOAD.setOnAction(event -> LoadFile.loadProject());
            this.EXP.setOnAction(event -> ExportGrid.export());
            return new Scene(ancora);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
