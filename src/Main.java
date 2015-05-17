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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
                Stage x = new Stage();
                Text t1 = new Text("Do you really want to close application?");
                Button b1 = new Button("Yes");
                b1.setOnAction((even) -> System.exit(0)); //   Add configuration file save methods
                Button b2 = new Button("No");
                VBox h= new VBox(b1,b2);
                h.setAlignment(Pos.CENTER);
                h.setSpacing(40);
                Scene clos = new Scene(h);
                x.setScene(clos);
                x.show();

            }
        });
        UIManager UIMAN = UIManager.getInstance();
        UIMAN.setMainScene(initRes());
        MangedGridFX Grid = new MangedGridFX();
        TableViewer view = new TableViewer();
        primaryStage.setScene(UIMAN.getMainScene());
        UIMAN.setTable(view);
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
