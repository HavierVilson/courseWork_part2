import java.util.Scanner;

public class DailyPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean workStatus = true;
        String inputValue;
        while (workStatus) {
            inputValue = scanner.nextLine();
            switch (inputValue) {
                case "Стоп":
                    workStatus = false;
                    System.out.println("Работы программы завершена!");
                    break;
            }
        }
    }
}
