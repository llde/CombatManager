/**
 * Created by Lorenzo on 22/04/2015.
 * Alpha version of D&D position for play by forum adventures and combat.
 * Mine first Java GUI program.
 */

import CreateElement.TableViewer;
import Grid.MangedGridFX;
import Resource.UIManager;
import Util.ConfigurationFile;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
//This fields are assigned by the compiler with the FXML notation
    @FXML
    private Button  NEW;


    private static void iniz(String[] args){
        launch(args);
    }


    public static void main(String[] args) {
        ConfigurationFile.load("CombatManager.ini");
        ConfigurationFile config = ConfigurationFile.GetConfig();
        iniz(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        UIManager UIMAN = UIManager.getInstance();
        UIMAN.setMainScene(initRes());
        MangedGridFX Grid = new MangedGridFX();
        TableViewer view = new TableViewer();
        primaryStage.setScene(UIMAN.getMainScene());
        UIMAN.setMainStage(primaryStage);
        UIMAN.getMainStage().show();
    }

    public Scene initRes(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Resource/MainGUI.fxml"));
        loader.setController(this);
        try {
            ButtonBar ancora = loader.load();
            this.NEW.setOnAction(ActionEvent -> System.out.print("New clicked "));

            return new Scene(ancora);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
