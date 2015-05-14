package Resource;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Lorenzo on 08/05/2015.
 */
public class UIManager {
    private static UIManager ourInstance = new UIManager();
    private Stage MainStage;
    private Scene MainScene;
    private Scene GridScene;
    private Scene TableScene;
    private Scene BuilderScene;

    private UIManager() {
        this.BuilderScene = null;
        this.GridScene = null;
        this.MainScene = null;
        this.TableScene = null;
        this.MainStage = null;
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
}