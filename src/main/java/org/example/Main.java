package org.example;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
            try {//проверка на правильность ввода данных от пользователя
                while(true) { //цикл while для постоянной работы кода, пока пользователь не введет противоречащее значение

                    var number = new Scanner(System.in);//Создается объект "Scanner" с именем "number", который читает данные из стандартного ввода
                    System.out.print("Если хотите завершить программу - введите 1" + "\n" + "Если хотите продолжить или начать - 2: ");
                    int numberEx = number.nextInt();//С помощью метода "nextInt()" считываются целочисленные значения, введенные пользователем

                    if (numberEx == 2) {

                        double coordinatezemli = 6378.1;
                        var readCoordinate = new Scanner(System.in);
                        System.out.print("Введите долготу первой точки:");
                        double coordinateFirstD = Math.toRadians(readCoordinate.nextDouble());//Math.toRadians - функция в JavaScript, которая принимает значение в градусах и возвращает это значение в радианах.

                        var readShirota = new Scanner(System.in);
                        System.out.print("Введите широту первой точки:");
                        double coordinateFirstSH = Math.toRadians(readShirota.nextDouble());

                        System.out.print("Введите долготу второй точки:");
                        double coordinateSecondD = Math.toRadians(readCoordinate.nextDouble());

                        System.out.print("Введите широту второй точки:");
                        double coordinateSecondSH = Math.toRadians(readShirota.nextDouble());

                        double lonDiff = coordinateSecondD - coordinateFirstD;// вычетание долготы второй точки из первой
                        double latDiff = coordinateSecondSH - coordinateFirstSH;// вычетание ширины второй точки из первой

                        double a = Math.pow(Math.sin(latDiff / 2), 2) +
                                Math.cos(coordinateFirstSH) * Math.cos(coordinateSecondSH) *
                                        Math.pow(Math.sin(lonDiff / 2), 2);
                        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));//математическая формула для вычисления расстояния между координатами на земной поверхности

                        System.out.println("Расстояние между точками: " + c * coordinatezemli + " км");

                    } else if (numberEx == 1) {
                        break;
                    }// если пользоваетль введет 1, то программа завершится
                }

            } catch (
                    Exception e) {//если код был выполнен некорретно, то будет выводиться описание более точное для ошибки
                System.out.print(e);
            }
    }
}
