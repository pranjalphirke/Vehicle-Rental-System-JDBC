import java.util.Scanner;
import dao.VehicleDAO;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VehicleDAO dao = new VehicleDAO();

        while (true) {
            System.out.println("\n--- Vehicle Rental System ---");
            System.out.println("1. View Available Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dao.showAvailableVehicles();
                    break;

                case 2:
                    System.out.print("Enter Vehicle ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    dao.rentVehicle(id, name);
                    break;

                case 3:
                    System.out.print("Enter Vehicle ID: ");
                    int returnId = scanner.nextInt();
                    dao.returnVehicle(returnId);
                    break;

                case 4:
                    System.out.println("Thank you for using the system.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
