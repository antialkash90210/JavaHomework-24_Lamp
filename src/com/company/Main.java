package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception  {

        LampsManager lampsManager = new LampsManager();
        int action = -1;
        boolean isRun = true;

        while (isRun) {

            lampsManager.printLamps();

            ConsoleHelper.PrintMessage("Меню:");
            ConsoleHelper.PrintMessage("1. Создать стандартную лампу накаливания и добавить в конец списка");
            ConsoleHelper.PrintMessage("2. Удалить лампу по ИД");
            ConsoleHelper.PrintMessage("3. Изменить мощность лампы по ИД");
            ConsoleHelper.PrintMessage("4. Изменить цветовую гамму лампы по ИД");
            ConsoleHelper.PrintMessage("5. Изменить цоколь лампы по ИД");
            ConsoleHelper.PrintMessage("6. Изменить марку лампы по ИД");
            ConsoleHelper.PrintMessage("7. Изменить тип лампы по ИД");
            ConsoleHelper.PrintMessage("8. Изменить цвет лампы по ИД");
            ConsoleHelper.PrintMessage("0. Выход");

            action = ConsoleHelper.InputInt("Введите номер пункта меню: ", 0, 8);

            switch (action) {
                case 1: {
                    int power = ConsoleHelper.InputInt("Введите мощность лампочки(вт)");
                    int colourTemperature = ConsoleHelper.InputInt("Введите цветовую гамму лампочки(К): ");
                    String base = ConsoleHelper.InputString("Введите тип цоколи лампы: ");
                    String brandName = ConsoleHelper.InputString("Введите марку лампы: ");
                    String typeLamp = ConsoleHelper.InputString("Введите модель лампы: ");
                    int colorIndex = ConsoleHelper.InputInt("Введите индекс цвета(0-красный, 1-жёлтый, 2-белый ): ", 0, 2);
                    Lamp.Color color = Lamp.Color.values()[colorIndex];

                    lampsManager.addLamp(power, colourTemperature, base, brandName, typeLamp, color);
                }
                break;

                case 2: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампы: ");
                        lampsManager.deleteCar(id);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 3: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампы для изменения мощности: ");
                        int power = ConsoleHelper.InputInt("Введите мощность лампы(вт): ");
                        lampsManager.getByIdLamp(id).setPower(power);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 4: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампы для изменения цветовой гаммы: ");
                        int colourTemperature = ConsoleHelper.InputInt("Введите цветовую гамму лампы(К): ");
                        lampsManager.getByIdLamp(id).setColourTemperature(colourTemperature);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 5: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампы для изменения цоколя: ");
                        String base = ConsoleHelper.InputString("Введите цоколь лампы: ");
                        lampsManager.getByIdLamp(id).setBase(base);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 6: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампы для изменения марки: ");
                        String brandName = ConsoleHelper.InputString("Введите марку лампы: ");
                        lampsManager.getByIdLamp(id).setBrandName(brandName);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 7: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампы для изменения типа: ");
                        String typeLamp = ConsoleHelper.InputString("Введите тип лампы: ");
                        lampsManager.getByIdLamp(id).setTypeLamp(typeLamp);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 8: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампы для изменения цвета: ");
                        int colorIndex = ConsoleHelper.InputInt("Введите индекс цвета(0-красный, 1-жёлтый, 2-белый ): ", 0, 2);
                        Lamp.Color color = Lamp.Color.values()[colorIndex];
                        lampsManager.getByIdLamp(id).setColor(color);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 0: {
                    isRun = false;
                }
                break;

                default: {
                    ConsoleHelper.PrintMessage("Ошибка. Такой команды не существует");
                }
                break;
            }
        }
    }
}