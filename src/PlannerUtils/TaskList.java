package PlannerUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class TaskList {
    private static HashMap<Integer, Task> taskList = new HashMap<>();
    private static HashMap<Integer, Task> archiveList = new HashMap<>();

    public static void addTaskToList(Scanner scanner) {
        Task task = new Task(Utils.enterTitle(scanner),
                Utils.enterDescription(scanner),
                Utils.enterDateOfWork(scanner),
                Utils.enterPurpose(scanner),
                Utils.enterRepeat(scanner));
        taskList.put(task.getID(), task);
        System.out.println("Задача создана!\n");
    }

    public static void printTaskList() {
        for (Task task : taskList.values()) {
            if (task.isTaskDeleted()) {
                continue;
            } else {
                System.out.print("\n" + task + "\n");
            }
            System.out.println();
        }
    }

    public static void printArchiveTaskList() {
        for (Task task : archiveList.values()) {
            System.out.print("\n" + task + "\n");
            System.out.println();
        }
    }

    public static void printTaskOnDay(Scanner scanner) {
        System.out.print("\nВ каком году искать задачу: ");
        int year = scanner.nextInt();
        System.out.print("В каком месяце искать задачу (Числом): ");
        int month = scanner.nextInt();
        System.out.print("Какой день искать: ");
        int day = scanner.nextInt();
        LocalDate findDate = LocalDate.of(year, month, day);
        for (Task task : taskList.values()) {
            if (task.getDateOfWork().isBefore(findDate) && task.getHowOftenRepeat() != Repeat.ONE_TIME) { // Проверяем не просрочилась ли задача \(0 _ 0)/
                if (task.getHowOftenRepeat() == Repeat.DAILY) {
                    while (task.getDateOfWork().isBefore(findDate)) {
                        task.setDateOfWork(task.getDateOfWork().plusDays(1));
                    }
                } else if (task.getHowOftenRepeat() == Repeat.WEEKLY) {
                    while (task.getDateOfWork().isBefore(findDate)) {
                        task.setDateOfWork(task.getDateOfWork().plusWeeks(1));
                    }
                } else if (task.getHowOftenRepeat() == Repeat.MONTHLY) {
                    while (task.getDateOfWork().isBefore(findDate)) {
                        task.setDateOfWork(task.getDateOfWork().plusMonths(1));
                    }
                } else if (task.getHowOftenRepeat() == Repeat.YEARLY) {
                    while (task.getDateOfWork().isBefore(findDate)) {
                        task.setDateOfWork(task.getDateOfWork().plusYears(1));
                    }
                }
            }
            if (task.getDateOfWork().isEqual(findDate)) {
                System.out.print("\n" + task + "\n");
            }
        }
    }

    public static void deleteTaskList(Scanner scanner) {
        System.out.print("\nВведите ID задачи: ");
        int findID = scanner.nextInt();
        taskList.get(findID).setTaskDeleted(true);
        taskList.get(findID).setDateOfDeleted(LocalDate.now());
        archiveList.put(taskList.get(findID).getID(), taskList.get(findID));
        System.out.println("\nЗадача удалена и помещена в архив\n");
    }
}
