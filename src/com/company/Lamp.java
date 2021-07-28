package com.company;

public class Lamp {
    // region Enum Color

    public enum Color {
        red("красный"),
        yellow("желтый"),
        white("белый");

        private final String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    //endregion

    //region Variables
    private int id;
    private int power;
    private int colourTemperature;
    private String base;
    private String brandName;
    private String typeLamp;
    private Color color;

    //endregion

    //region Constructor

    public Lamp() {
        id = 0;
        power = 10;
        colourTemperature = 3000;
        base = "E14";
        brandName = "Philips";
        typeLamp = "Светодиодная";
        color = Color.white;
    }

    public Lamp(int id, int power, int colourTemperature, String base, String brandName, String typeLamp, Color color) {
        this.id =id;
        this.power = power;
        this.colourTemperature = colourTemperature;
        this.base = base;
        this.brandName = brandName;
        this.typeLamp = typeLamp;
        this.color = Color.white;
    }

    public Lamp(int id, Lamp lamp) {
        this.id = id;
        power = lamp.power;
        colourTemperature = lamp.colourTemperature;
        base = lamp.base;
        brandName = lamp.brandName;
        typeLamp = lamp.typeLamp;
        color = lamp.color;
    }

    //endregion

    //region Setters
    public void setPower(int power) throws Exception {

        if (power <= 0) {
            throw new Exception("мощность должна быть больше 0");
        }
        this.power = power;

    }

    public void setColourTemperature(int colourTemperature) throws Exception {
        if (colourTemperature <= 0 || colourTemperature > 4000 ) {
            throw new Exception("цветовая гамма должна быть больше 0 или меньше 4000 ");
        }
        this.colourTemperature = colourTemperature;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setTypeLamp(String typeLamp) {
        this.typeLamp = typeLamp;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    //endregion

    //region Getters
    public int getId() {
        return id;
    }

    public int getPower(){
        return power;
    }

    public int getColourTemperature() {
        return colourTemperature;
    }

    public void getBase(String base) {
        this.base = base;
    }

    public void getBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void getTypeLamp(String typeLamp) {
        this.typeLamp = typeLamp;
    }

    public Color getColor() {
        return color;
    }
    //endregion

    public String getInString() {
        String output = "";

        output += "ИД: " + id + "\n";
        output += "мощность лампы " + power + "(Вт)\n";
        output += "цветовая гамма " + colourTemperature + "(К)\n";
        output += "цоколь " + base + "\n";
        output += "марка " + brandName + "\n";
        output += "тип лампы " + typeLamp + "\n";
        output += "цвет " + color.getValue() + "\n";

        return output;
    }

}