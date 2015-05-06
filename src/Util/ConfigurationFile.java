package Util;

import Gridder.Gridable;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Lorenzo on 25/04/2015.
 * TODO save/load ini.
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

    private  static ConfigurationFile istanza = null;

    private ConfigurationFile(){  //default
        this.allowResize = true;
        this.allowNullify = true;
        this.numberGridRow = 50;
        this.numberGridColumn = 50;
        this.xLenghtBlock = 10;
        this.yLenghtBlock = 10;
        this.colorDefault = Color.WHITE;
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

    public Color getColorDefault() {
        return colorDefault;
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

    public static void load(Path c){}

    public void save(){
        Map<String, Object > toSave = new HashMap<String, Object>();
        String nomefile = "CombatManager.ini";
        java.util.List<String> tt = new ArrayList<>();
        toSave.put("GridNumberRow" , getNumberGridRow());
        toSave.put("GridNumberColumn", getNumberGridColumn());
        toSave.put("Resolution High Block", getyLenghtBlock());
        toSave.put("Resolution Lenght Block" , getxLenghtBlock());
        toSave.put("Default Color Background", getColorDefault());
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