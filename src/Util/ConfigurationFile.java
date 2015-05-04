package Util;

import Gridder.Gridable;

import java.awt.*;

/**
 * Created by Lorenzo on 25/04/2015.
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
        this.numberGridRow = 10;
        this.numberGridColumn = 10;
        this.xLenghtBlock = 40;
        this.yLenghtBlock = 40;
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

    public static void load(){}

    public void save(){} //reindirizza al demone

}