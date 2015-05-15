package CreateElement;

import Resource.UIManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Lorenzo on 08/05/2015.
 */
public class BuilderScene  {
    public BuilderScene(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Resource/BuilderGui.fxml"));
        try{
           AnchorPane loaded = loader.load();
            Scene scen = new Scene(loaded);
            UIManager.getInstance().setBuilderScene(scen);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}