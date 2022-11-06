package KP2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Diary {
    ;
    static List<Task> tasks = new ArrayList<>();
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:

                            System.out.print("Введите id задачи, которую вы хотите удалить");
                            Schedule.removeTask(scanner.nextInt());

                            break;
                        case 3:
                            System.out.print("Введите дату, на которую бы вы хотели увидеть список дел" +
                                    " в формате dd.MM.yyyy");
                            try {
                                Schedule.getTaskforDay(LocalDate.parse(scanner.next(), df));
                            } catch (DateTimeParseException e) {
                                System.out.println("Ошибка : неправильный ввод");
                            }
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.println("Введите описание задачи: ");
        String taskDescription = scanner.useDelimiter("\n").next();
        System.out.println("Это рабочая задача? <Y/N>");
        boolean typeTask = true;
        typeTask = "y".equals(scanner.next().toLowerCase(Locale.ROOT));
        if (typeTask) {
            System.out.println("Это рабочая задача");
        } else System.out.println("Это личная задача");
        System.out.println("Введите повторяемость задачи: ");
        System.out.print(" 0 - одноразовая");
        System.out.print(" 1 - ежедневная");
        System.out.print(" 2 - еженедельная");
        System.out.print(" 3 - ежемесячная");
        System.out.print(" 4 - ежегодная");
        int repeatability = scanner.nextInt();
        System.out.print("Введите дату и время старта в формате dd.MM.yyyy HH:mm:ss");
        String stringData = scanner.next();
        try {
            LocalDateTime ldt = LocalDateTime.parse(stringData, dtf);

            Task task;

            switch (repeatability) {
                case 0:
                    task = new OneTimeTask(taskName, taskDescription, typeTask, ldt);
                    break;
                case 1:
                    task = new DailyTask(taskName, taskDescription, typeTask, ldt);
                    break;
                case 2:
                    task = new WeeklyTask(taskName, taskDescription, typeTask, ldt);
                    break;
                case 3:
                    task = new MonthlyTask(taskName, taskDescription, typeTask, ldt);
                    break;
                case 4:
                    task = new AnnualTask(taskName, taskDescription, typeTask, ldt);
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect type task");
            }
            Schedule.addTask(task);
            System.out.println("Задача добавлена успешно " + task);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка : неправильный ввод");
        }

    }

    private static void printMenu() {
        System.out.println(

                " 1. Добавить задачу " +
                        " 2. Удалить задачу" +
                        "3. Получить задачу на указанный день" +
                        "0. Выход"

        );
    }
}