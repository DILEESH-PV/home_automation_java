import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice, humidity, moisture;
        float temperature;
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Add a data");
            System.out.println("2. View all datas");
            System.out.println("3. Search data");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add data");
                    break;
                case 2:
                    System.out.println("View all data");
                    break;
                case 3:
                    System.out.println("Search data");
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
}

