/*
01. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */

import java.util.Random;
import java.util.Scanner;
public class guessNumber {
    public static Scanner scanner = new Scanner(System.in);

    public static int generateNumber() {            // Метод герерирует число в рамках диапазона
        Random rand = new Random();
        int number = rand.nextInt(9);
        return number;
    }

    private static void game(int number, int counter) {   // Метод с телом игры
        System.out.println("У вас есть три попытки угадать число от 0 до 9");
        while (true) {

            int inputNumber = scanner.nextInt();

            if (inputNumber == number) {
                System.out.println("Вы угадали!");
                break;
            } else if (inputNumber > number) {
                System.out.println("Загаданное число меньше");
                counter++;
            } else {
                System.out.println("Загаданное число больше");
                counter++;
            }

            if (counter >= 3) {
                System.out.println("Попытки исчерпаны! Вы проиграли!");
                break;
            }
        }

    }

    private static void askExit () {                 // Меню после окончания игры
        System.out.println("Хотите сыграть еще раз?");
        System.out.println("0 - НЕТ , 1 - ДА");
        int choise = scanner.nextInt();
        if (choise == 0) {
            scanner.close();
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        while (true) {
            game(generateNumber(), 0); // Вызываем игру, передаем сгенерированное число, обнуляем счетчик попыток
            askExit();                         // Вызываем меню
        }
    }
}

