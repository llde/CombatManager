package Util;

import Daemon.GriddableCreator;
import Resource.UIManager;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swing.SwingNode;
import javafx.scene.control.TableView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Lorenzo on 22/04/2015.
 * Grid to image. PNG??
 */
public class ExportGrid {
    public static void export(){
        FileChooser choose = new FileChooser();
        choose.setTitle("Save the Grid");
        choose.setInitialDirectory(new File("./"));
        File file = choose.showSaveDialog(UIManager.getInstance().getMainStage());
        if(file == null) return;
        choose.setTitle("Save the Table");
        choose.setInitialDirectory(new File(file.getParent()));
        File file1 = choose.showSaveDialog(UIManager.getInstance().getMainStage());
        SwingNode SwingFX = UIManager.getInstance().getGrid().exportSwingPane();
        TableView<GriddableCreator> table = UIManager.getInstance().getTable().exportTable();
        try {
            WritableImage img = new WritableImage(1024,1024);
            WritableImage im = new WritableImage(512,512);
            SwingFX.snapshot(null,img);
            table.snapshot(null,im);
            ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", file);
            ImageIO.write(SwingFXUtils.fromFXImage(im,null), "png", file1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
