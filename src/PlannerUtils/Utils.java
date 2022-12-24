package PlannerUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class Utils {
    public static String enterTitle(Scanner scanner) {
        try {
            System.out.print("\nВведите название задачи: ");
            String taskTitle = scanner.next();
            if (taskTitle == null || taskTitle.isEmpty() || taskTitle.isBlank()) {
                throw new WrongTitle("\nОшибка ввода заголовка!");
            }
            return taskTitle;
        } catch (WrongTitle ex) {
            System.out.println(ex.getMessage());
            return "Bad Title";
        }
    }

    public static String enterDescription(Scanner scanner) {
        try {
            System.out.print("Введите описание задачи: ");
            String taskDescription = scanner.next();
            if (taskDescription == null || taskDescription.isEmpty() || taskDescription.isBlank()) {
                throw new WrongDescription("\nОшибка ввода заголовка!");
            }
            return taskDescription;
        } catch (WrongDescription ex) {
            System.out.println(ex.getMessage());
            return "Bad Description";
        }
    }
    public static LocalDate enterDateOfWork(Scanner scanner) {
        try {
            System.out.print("На какой год поставить задачу: ");
            int year = scanner.nextInt();
            if (year <= 1){
                throw new WrongDate("\nОшибка ввода даты!");
            }
            System.out.print("На какой месяц поставить задачу (Числом): ");
            int month = scanner.nextInt();
            if (month <= 0 || month > 12){
                throw new WrongDate("\nОшибка ввода даты!");
            }
            System.out.print("На какой день поставить задачу: ");
            int day = scanner.nextInt();
            if (day <= 1){
                throw new WrongDate("\nОшибка ввода даты!");
            }
            LocalDate dateOfWork = LocalDate.of(year,month,day);
            return dateOfWork;
        } catch (WrongDate ex){
            System.out.println(ex.getMessage());
            return LocalDate.now();
        }
    }

    public static Purpose enterPurpose(Scanner scanner){
        System.out.print("Записать задачу в личные или рабочие:\n1. Личные\n2. Рабочие\nВыберите пункт меню:  ");
        int purposeScanner = scanner.nextInt();
        switch (purposeScanner){
            case 1:
                return Purpose.FOR_ME;
            case 0:
                return Purpose.FOR_WORK;
            default:
                System.out.println("\nОшибка ввода");
                return Purpose.FOR_ME;
        }
    }

    public static Repeat enterRepeat(Scanner scanner){
        System.out.print("Нужно ли повторять задачу:\n1. Не повторять\n2. Ежедневно\n3. Ежеднедельно\n4. Ежемесячно\n5. Ежегодно\nВыберите пункт меню:  ");
        int purposeScanner = scanner.nextInt();
        switch (purposeScanner){
            case 1:
                return Repeat.ONE_TIME;
            case 2:
                return Repeat.DAILY;
            case 3:
                return Repeat.WEEKLY;
            case 4:
                return Repeat.MONTHLY;
            case 5:
                return Repeat.YEARLY;
            default:
                System.out.println("\nОшибка ввода");
                return Repeat.ONE_TIME;
        }
    }
}

class WrongTitle extends Exception {
    public WrongTitle(String msg) {
        super(msg);
    }
}
class WrongDescription extends Exception {
    public WrongDescription(String msg) {
        super(msg);
    }
}

class WrongDate extends Exception {
    public WrongDate(String msg){
        super(msg);
    }
}