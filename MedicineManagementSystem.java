import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MedicineManagementSystem {
    private Map<String, Integer> medicineInventory;

    public MedicineManagementSystem() {
        medicineInventory = new HashMap<>();
    }

    public void addMedicine(String medicineName, int quantity) {
        if (medicineInventory.containsKey(medicineName)) {
            int currentQuantity = medicineInventory.get(medicineName);
            medicineInventory.put(medicineName, currentQuantity + quantity);
        } else {
            medicineInventory.put(medicineName, quantity);
        }
        System.out.println("Medicine added successfully!");
    }

    public void sellMedicine(String medicineName, int quantity) {
        if (medicineInventory.containsKey(medicineName)) {
            int currentQuantity = medicineInventory.get(medicineName);
            if (currentQuantity >= quantity) {
                medicineInventory.put(medicineName, currentQuantity - quantity);
                System.out.println("Medicine sold successfully!");
            } else {
                System.out.println("Insufficient quantity. Available quantity: " + currentQuantity);
            }
        } else {
            System.out.println("Medicine not found!");
        }
    }

    public void displayInventory() {
        System.out.println("Medicine Inventory:");
        for (Map.Entry<String, Integer> entry : medicineInventory.entrySet()) {
            System.out.println("Medicine: " + entry.getKey());
            System.out.println("Quantity:" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        MedicineManagementSystem medicineManagementSystem = new MedicineManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        String medicineName;
        int quantity;

        do {
            System.out.println("\n Welcome To Medicine Management System Menu:");
            System.out.println("1. Add Medicine");
            System.out.println("2. Sell Medicine");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter medicine name: ");
                    scanner.nextLine();
                    medicineName = scanner.nextLine();
                    System.out.print("Enter your quantity: ");
                    quantity = scanner.nextInt();
                    medicineManagementSystem.addMedicine(medicineName, quantity);
                    break;
                case 2:
                    System.out.print("Enter medicine name: ");
                    scanner.nextLine();
                    medicineName = scanner.nextLine();
                    System.out.print("Enter your quantity: ");
                    quantity = scanner.nextInt();
                    medicineManagementSystem.sellMedicine(medicineName, quantity);
                    break;
                case 3:
                    medicineManagementSystem.displayInventory();
                    break;
                case 4:
                    System.out.println("Server Stoped");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}