/**
 * Created by Lorenzo on 22/04/2015.
 * Alpha version of D&D position for play by forum adventures and combat.
 * Mine first Java GUI program.
 */
import CreateElement.MainGUI;
import Util.ConfigurationFile;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
//This fields are assigned by the compiler with the FXML notation
    @FXML
    private Button  NEW;

    @FXML
    private GridPane GridModel;

    @FXML
    private TableView TableGen;


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
        primaryStage.setScene(initRes());
        primaryStage.show();
    }

    public Scene initRes(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Resource/MainGUI.fxml"));
        loader.setController(this);
        try {
            TitledPane ancora = loader.load();
            this.NEW.setOnAction(ActionEvent -> System.out.print("New clicked "));
            return new Scene(ancora);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
