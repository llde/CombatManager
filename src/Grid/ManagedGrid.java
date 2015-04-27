package Grid;

import Gridder.Gridable;
import sun.reflect.misc.ReflectUtil;
import sun.swing.PrintingStatus;
import sun.swing.SwingUtilities2;

import javax.accessibility.*;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.plaf.TableUI;
import javax.swing.plaf.UIResource;
import javax.swing.table.*;
import javax.swing.text.TableView;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.print.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.*;

import static sun.swing.SwingUtilities2.Section.LEADING;
import static sun.swing.SwingUtilities2.Section.MIDDLE;
import static sun.swing.SwingUtilities2.Section.TRAILING;

/**
 * Created by Lorenzo on 22/04/2015.
    Estensione della classe JTable per una grid multicomponente
 */
public class ManagedGrid extends JComponent  {
    public static JTable GetTableSingleton() {
        JTable table = new JTable(new Renders.ManagedGridTable(),null,null);
        Renders.GridCellRender gridrender  = new Renders.GridCellRender();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  //Disable native autoresize
  //      table.setColumnModel(null);
        for(int index = 0; index < table.getColumnCount(); index++){
            TableColumn colonna = table.getColumnModel().getColumn(index);
   //         colonna.setHeaderValue(null);  //Swing di merda!
            colonna.setResizable(false);
     //       colonna.setMinWidth(40);
     //       colonna.setMaxWidth(40);
            colonna.setPreferredWidth(40);
        }
        table.setRowHeight(40);
        table.setRowMargin(0);
        table.setTableHeader(null);
        gridrender.setOpaque(true);
        table.setDefaultRenderer(Object.class, gridrender);
        table.repaint();
        return table;
    }
}
