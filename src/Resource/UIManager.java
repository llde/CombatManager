package Resource;

import CreateElement.TableViewer;
import Grid.MangedGridFX;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Lorenzo on 08/05/2015.
 */
public class UIManager {
    private static UIManager ourInstance = new UIManager();
    private Scene MainScene;
    private Scene GridScene;
    private Scene TableScene;
    private Scene BuilderScene;
    private Stage TableStage;
    private Stage MainStage;
    private Stage GridStage;
    private TableViewer table;
    private MangedGridFX grid;

    private UIManager() {
        this.BuilderScene = null;
        this.GridScene = null;
        this.MainScene = null;
        this.TableScene = null;
        this.MainStage = null;
        this.TableStage = null;
        this.GridStage = null;
    }

    public static UIManager getInstance() {
        return ourInstance;
    }

    public Scene getTableScene() {
        return TableScene;
    }

    public void setTableScene(Scene tableScene) {
        TableScene = tableScene;
    }

    public Scene getGridScene() {
        return GridScene;
    }

    public void setGridScene(Scene gridScene) {
        GridScene = gridScene;
    }

    public Scene getMainScene() {
        return MainScene;
    }

    public void setMainScene(Scene mainScene) {
        MainScene = mainScene;
    }

    public Scene getBuilderScene() {
        return BuilderScene;
    }

    public void setBuilderScene(Scene builderScene) {
        BuilderScene = builderScene;
    }

    public Stage getMainStage() {
        return MainStage;
    }

    public void setMainStage(Stage mainStage) {
        MainStage = mainStage;
    }

    public Stage getTableStage() {
        return TableStage;
    }

    public void setTableStage(Stage tableStage) {
        TableStage = tableStage;
    }

    public void setGridStage(Stage gridStage){
        GridStage = gridStage;
    }

    public Stage getGridStage(){
        return GridStage;
    }

    public TableViewer getTable() {
        return table;
    }

    public void setTable(TableViewer table) {
        this.table = table;
    }

    public void setGrid(MangedGridFX grid) {this.grid = grid;}

    public MangedGridFX getGrid(){return  this.grid;}

}
