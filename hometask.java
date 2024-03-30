package GeekBrains.Java.Exceptions;

import GeekBrains.Java.Exceptions.Exceptions.InvalidBirthDateException;
import GeekBrains.Java.Exceptions.Exceptions.InvalidGenderException;
import GeekBrains.Java.Exceptions.Exceptions.InvalidNamesException;
import GeekBrains.Java.Exceptions.Exceptions.InvalidPhoneNumberException;

import java.util.Scanner;

public class hometask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Введите данные в произвольном порядке (Фамилия Имя Отчество Дата_рождения Номер_телефона Пол), разделенные пробелом:");
        String input = scanner.nextLine();

        try {

            if (checkDataLength(input) == -1) {
                System.err.println("Ошибка: Неверное количество данных");
            } else {
                ResultWrapper result = new ResultWrapper(input);
                String[] userData = result.getResult();
                StringBuilder output = new StringBuilder();
                for (String value : userData) {
                    output.append("<").append(value).append(">");
                }
                output.append("\n");
                WriteFile wf = new WriteFile(output, userData[0]);
                wf.writeDataToFile();
            }
        } catch (InvalidPhoneNumberException e) {
            e.getStackTrace("Ошибка: Некорректный формат номера телефона. Номер телефона должен содержать только цифры.");
        } catch (InvalidGenderException e) {
            e.getStackTrace("Ошибка: Некорректный символ пола. Используйте 'm' для мужского и 'f' для женского.");
        } catch (InvalidBirthDateException e) {
            e.getStackTrace("Ошибка: Некорректный формат даты рождения. Используйте формат dd.MM.yyyy.");
        } catch (InvalidNamesException e) {
            e.getStackTrace("Ошибка: Фамилия, имя или отчество не должны содержать цифры.");
        }
    }

    public static int checkDataLength(String input) {
        String[] data = input.split("\\s+");
        if (data.length != 6) {
            return -1;
        } else
            return 0;
    }
}
