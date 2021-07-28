package com.company;

public class LampsManager {
    private int id;
    private Lamp[] lamps;

    public LampsManager () {
        id = 0;
        lamps = new Lamp[0];
    }

    //region Util Methods
    private int getIndexByIdLamp(int id) {

        int index = -1;
        int middle = lamps.length / 2;
        int first = 0;
        int last = lamps.length - 1;

        if (id < lamps[first].getId() || id > lamps[last].getId()) {
            return -1;
        }

        do {
            if (id < lamps[middle].getId()) {
                last = middle - 1;
                middle = (first + last) / 2;
            } else if (id > lamps[middle].getId()) {
                first = middle + 1;
                middle = (first + last) / 2;

            } else {
                index = middle;
                break;
            }
        }
        while (first <= last);

        return index;
    }
    //endregion

    //region Main Methods
    public void addLamp(int power, int colourTemperature, String base, String brandName, String type, Lamp.Color color) {
        id++;
        Lamp lamp = new Lamp(id, power, colourTemperature, base, brandName, type, color);

        Lamp[] tempLamps = new Lamp[lamps.length + 1];

        for (int i = 0; i < lamps.length; i++) {
            tempLamps[i] = lamps[i];
        }

        tempLamps[tempLamps.length-1] = lamp;

        lamps = tempLamps;
    }

    public void deleteCar(int id) throws Exception {
        int index = getIndexByIdLamp(id);

        if (index == -1) {
            throw new Exception("car with id = " + id + " not found");
        }

        Lamp[] tempCars = new Lamp[lamps.length - 1];

        for (int i = 0; i < index; i++) {
            tempCars[i] = lamps[i];
        }

        for (int i = index + 1; i < lamps.length; i++) {
            tempCars[i - 1] = lamps[i];
        }

        lamps = tempCars;
    }

    public Lamp getByIdLamp(int id) throws Exception {
        int index = getIndexByIdLamp(id);

        if (index == -1) {
            throw new Exception("car with id = " + id + " not found");
        }

        return lamps[index];
    }

    public void printLamps() {
        if (lamps.length == 0) {
            System.out.println("Список ламп накаливания");
            System.out.println("==========");
        } else {
            for (int i = 0; i < lamps.length; i++) {
                System.out.println(lamps[i].getInString());
                System.out.println("==========");
            }
        }
    }
    //endregion
}