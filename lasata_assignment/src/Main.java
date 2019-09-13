import controller.FreightController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FreightController obj = new FreightController();

        int choice = 5;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("1. Add\n2.Update\n3. Display Freights\n4. Display Voucher\n5. Exit");
            System.out.println("Enter the operation: ");
            choice = scan.nextInt();
            switch (choice)
            {
                case 1:
                    obj.addFreightOrder();
                    break;
                case 2:
                    obj.updateFreight();
                    break;
                case 3:
                    obj.displayFreights();
                    break;
                case 4:
                    obj.displayVouchers();
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}
