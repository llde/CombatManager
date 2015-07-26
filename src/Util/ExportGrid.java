package Util;

import Daemon.GriddableCreator;
import Resource.UIManager;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swing.SwingNode;
import javafx.scene.control.TableView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Lorenzo on 22/04/2015.
 * Grid to image. PNG??
 */
public class ExportGrid {
    public static void export(){
        SwingNode SwingFX = UIManager.getInstance().getGrid().exportSwingPane();
        TableView<GriddableCreator> table = UIManager.getInstance().getTable().exportTable();
        try {
            WritableImage img = new WritableImage(1024,1024);
            WritableImage im = new WritableImage(512,512);
            SwingFX.snapshot(null,img);
            table.snapshot(null,im);
            ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", new File("./grid.png"));
            ImageIO.write(SwingFXUtils.fromFXImage(im,null), "png", new File("./table.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
