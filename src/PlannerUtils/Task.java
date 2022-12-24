package PlannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task { //Класс отвечате за создание самой задачи
    private final int iD;
    private int counter = 1;
    private boolean taskDeleted;
    public Repeat howOftenRepeat;
    public Purpose purpose;
    private final LocalDate dateOfCreation;
    private LocalDate dateOfWork;
    private LocalDate dateOfDeleted;
    private String taskTitle;
    private String taskDescription;

    public Task(String taskTitle, String taskDescription, LocalDate dateOfWork, Purpose purpose, Repeat howOftenRepeat) {
        this.iD = counter; // счетсчик  id
        this.dateOfCreation = LocalDate.now(); // сохраняем дату создания задачи
        this.taskTitle = taskTitle; // создаём заголовок задачи
        this.taskDescription = taskDescription; // создаём описание задачи
        this.dateOfWork = dateOfWork; // запись данных о тригере срабатывания
        this.purpose = purpose; // узнаем цель задачи
        this.howOftenRepeat = howOftenRepeat; // узнаём надо-ли повторять задачу
        this.taskDeleted = false; //переменная архивации
        counter++; //Увеличиваем счетчик
    }

    public int getID() {
        return iD;
    }

    public int getCounter() {
        return counter;
    }
    public boolean isTaskDeleted() {
        return taskDeleted;
    }

    public void setTaskDeleted(boolean taskDeleted) {
        this.taskDeleted = taskDeleted;
    }

    public Repeat getHowOftenRepeat() {
        return howOftenRepeat;
    }

    public void setHowOftenRepeat(Repeat howOftenRepeat) {
        this.howOftenRepeat = howOftenRepeat;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDate getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(LocalDate dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public LocalDate getDateOfDeleted() {
        return dateOfDeleted;
    }

    public void setDateOfDeleted(LocalDate dateOfDeleted) {
        this.dateOfDeleted = dateOfDeleted;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        if (!this.taskDeleted) {
            return "Задача: " + this.getTaskTitle() + "\nОписание: " + this.taskDescription + "\nДата оповещения: "
                    + this.dateOfWork.getDayOfMonth() + " " + this.dateOfWork.getMonth() + " " + this.dateOfWork.getYear()
                    + "\n\nДата создания: " + this.dateOfCreation + " iD: " + this.iD;
        } else {
            return "Задача: " + this.getTaskTitle() + "\nОписание: " + this.taskDescription + "\nДата архивировации: "
                    + this.dateOfDeleted.getDayOfMonth() + " " + this.dateOfDeleted.getMonth() + " " + this.dateOfDeleted.getYear()
                    + "\n\nДата создания: " + this.dateOfCreation;
        }
    }
}

enum Repeat {
    ONE_TIME, DAILY, WEEKLY, MONTHLY, YEARLY;
}

enum Purpose {
    FOR_ME, FOR_WORK;
}
