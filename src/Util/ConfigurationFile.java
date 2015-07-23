package Util;

import Daemon.GriddableCreator;
import Gridder.Gridable;
import Resource.UIManager;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Lorenzo on 25/04/2015.
 * TODO More option for Default Gridable. Add it to the Gridable TableView. Control the creation of the Gridable when loaded and saved
 */
public class ConfigurationFile {
    private int numberGridRow;
    private int numberGridColumn;
    private int xLenghtBlock;
    private int yLenghtBlock;
    private boolean allowResize;
    private String Locale;
    private boolean allowNullify;
    private transient Color colorDefault;
    private transient GriddableCreator gridabledCreator;
    private Gridable gridabled;

    private  static ConfigurationFile istanza = null;

    private ConfigurationFile(){  //default
        this.allowResize = true;
        this.allowNullify = true;
        this.numberGridRow = 100;
        this.numberGridColumn = 100;
        this.xLenghtBlock = 10;
        this.yLenghtBlock = 10;
        this.colorDefault = Color.RED;
        this.gridabledCreator = new GriddableCreator("Flora", "Base" , javafx.scene.paint.Color.rgb(colorDefault.getRed() , colorDefault.getGreen(), colorDefault.getBlue(), colorDefault.getAlpha()/255.0), false);
        this.gridabled = gridabledCreator.get();
        this.Locale = null;

    }

    public static ConfigurationFile GetConfig(){
        if(istanza == null){
            istanza = new  ConfigurationFile();
        }
        return istanza;
    }

    public int getNumberGridRow() {
        return numberGridRow;
    }

    public void setNumberGridRow(int numberGridRow) {
        this.numberGridRow = numberGridRow;
    }

    public int getNumberGridColumn() {
        return numberGridColumn;
    }

    public void setNumberGridColumn(int numberGridColumn) {
        this.numberGridColumn = numberGridColumn;
    }

    public int getxLenghtBlock() {
        return xLenghtBlock;
    }

    public void setxLenghtBlock(int xLenghtBlock) {
        this.xLenghtBlock = xLenghtBlock;
    }

    public String getLocale() {
        return Locale;
    }

    public GriddableCreator getGridabledCreator() {
        return gridabledCreator;
    }

    public void setGridabledCreator(GriddableCreator gridabledCreator) {
        this.gridabledCreator = gridabledCreator;
    }

    public void setLocale(String locale) {
        Locale = locale;
    }

    public boolean isAllowResize() {
        return allowResize;
    }

    public void setAllowResize(boolean allowResize) {
        this.allowResize = allowResize;
    }

    public int getyLenghtBlock() {
        return yLenghtBlock;
    }

    public void setyLenghtBlock(int yLenghtBlock) {
        this.yLenghtBlock = yLenghtBlock;
    }

    public Gridable getGridableDefault() {
        return this.gridabled;
    }

    public void setColorDefault(Color colorDefault) {
        this.colorDefault = colorDefault;
    }

    public boolean isAllowNullify() {
        return allowNullify;
    }

    public void setAllowNullify(boolean allowNullify) {
        this.allowNullify = allowNullify;
    }

    public static void load(String ini){
        Map<String, String>  tl = new HashMap<>();
        try {
            BufferedReader file = Files.newBufferedReader(Paths.get(ini), StandardCharsets.UTF_8);
            Stream<String> x = file.lines();
            x.forEach((s) -> tl.put(s.split("=")[0], s.split("=")[1]));
        }
        catch (IOException e){
            System.out.print("Cannot load file");
            e.printStackTrace();
        }
        istanza = new ConfigurationFile();
        for(Map.Entry ewl : tl.entrySet()){
            try {
                if (((String)ewl.getKey()).trim().equalsIgnoreCase("GridNumberRow")) {
                    istanza.setNumberGridRow(Integer.valueOf(((String) ewl.getValue()).trim()));
                    continue;
                }
                if (((String) ewl.getKey()).trim().equalsIgnoreCase("GridNumberColumn")) {
                    istanza.setNumberGridColumn(Integer.valueOf(((String) ewl.getValue()).trim()));
                    continue;
                }
                if (((String) ewl.getKey()).trim().equalsIgnoreCase("Resolution High Block")) {
                    istanza.setyLenghtBlock(Integer.valueOf(((String) ewl.getValue()).trim()));
                    continue;
                }
                if (((String) ewl.getKey()).trim().equalsIgnoreCase("Resolution Length Block")){
                    istanza.setxLenghtBlock(Integer.valueOf(((String) ewl.getValue()).trim()));
                    continue;
                }
                if (((String) ewl.getKey()).trim().equalsIgnoreCase("Allow Nullify")) {
                    istanza.setAllowNullify(Boolean.valueOf(((String) ewl.getValue()).trim()));
                    continue;
                }
                if (((String) ewl.getKey()).trim().equalsIgnoreCase("Allow Resize")) {
                    istanza.setAllowResize(Boolean.valueOf(((String) ewl.getValue()).trim()));
                    continue;
                }
                if (((String) ewl.getKey()).trim().equalsIgnoreCase("Locale")){
                    istanza.setLocale(((String) ewl.getValue()).trim());
                    continue;
                }
                if (((String) ewl.getKey()).trim().equalsIgnoreCase("Default Color Background")) {
                    istanza.setColorDefault(Color.getColor(((String) ewl.getValue()).trim()));
                    continue;
                }
                throw  new InvalidPropertiesFormatException("Setting invalid");
            }
            catch(Exception e){
                System.out.println("Impossible to decode "  + ((String)ewl.getKey()).trim()  + ewl.getValue() + " ." + e.getLocalizedMessage() + " Will use default setting");
            }
        }
    }

    public void save(){
        Map<String, Object > toSave = new HashMap<String, Object>();
        String nomefile = "CombatManager.ini";
        java.util.List<String> tt = new ArrayList<>();
        toSave.put("GridNumberRow" , getNumberGridRow());
        toSave.put("GridNumberColumn", getNumberGridColumn());
        toSave.put("Resolution High Block", getyLenghtBlock());
        toSave.put("Resolution Length Block" , getxLenghtBlock());
        toSave.put("Default Color Background", getGridableDefault());
        toSave.put("Allow Nullify" , isAllowNullify());
        toSave.put("Allow Resize", isAllowResize());
        toSave.put("Locale", getLocale());
        toSave.entrySet().stream().forEach((s) -> tt.add(s.getKey() + " = " + s.getValue()));
        Path questa = Paths.get(nomefile);
        try {
            BufferedWriter file = Files.newBufferedWriter(questa, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            for(String el : tt){
                file.write(el);
                file.newLine();
            }
            file.close();
        }
        catch(IOException e){
            System.out.print("Cannot create file, at directory " + questa.toAbsolutePath());
            e.printStackTrace();
        }
    } //reindirizza al demone

}